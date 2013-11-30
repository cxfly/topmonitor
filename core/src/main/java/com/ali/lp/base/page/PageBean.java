package com.ali.lp.base.page;

import java.io.Serializable;

public class PageBean implements Serializable {
    /** Comment for <code>serialVersionUID</code> . */
    private static final long serialVersionUID = -8132783218617126174L;
    private int               pageCount;
    private int               pageSize         = 20;
    private int               lastPageSize;
    private long              recordCount;
    private int               currentPage      = 1;

    public PageBean() {
        super();
    }

    public PageBean(int pageSize) {
        this.pageSize = pageSize;
    }

    protected void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setRecordCount(long recordCount) {
        this.recordCount = recordCount;

        if (this.pageSize != 0) {
            this.calculate();
        }
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void calculate() {
        this.pageCount = (int) recordCount / pageSize;

        this.lastPageSize = (int) this.recordCount % this.pageSize;

        if (this.lastPageSize == 0) {
            this.lastPageSize = this.pageSize;
        } else {
            this.pageCount++;
        }
    }

    public void setPage(long recordCount, int pageSize) {
        this.recordCount = recordCount;
        this.pageSize = pageSize;
        calculate();
    }

    public static PageBean createPageBean(long recordCount, int pageSize) {
        PageBean bean = new PageBean();
        bean.setPage(recordCount, pageSize);

        return bean;
    }

    public long getRecordCount() {
        if (pageCount == 0)
            return 0;
        return ((pageCount - 1) * pageSize) + lastPageSize;
    }

    public int getLastPageSize() {
        return this.lastPageSize;
    }

    public void setLastPageSize(int lastPageSize) {
        this.lastPageSize = lastPageSize;
    }

    public int getPageCount() {
        return this.pageCount;
    }

    public int getCurrentPageSize() {
        if (this.pageCount == this.currentPage) {
            return this.getLastPageSize();
        } else {
            return this.pageSize;
        }
    }

    public int getCurrentPageFirstRecord() {
        return (this.currentPage - 1) * this.pageSize;
    }

    public int getNextPageNo() {
        int result = this.currentPage + 1;

        if (result > this.pageCount) {
            result = this.pageCount;
        }

        return result;
    }

    public int getPrivPageNo() {
        int result = this.currentPage - 1;

        if (result < 1) {
            result = 1;
        }

        return result;
    }

    public boolean isNext() {
        return this.pageCount > this.currentPage;
    }

    public boolean isPriv() {
        return this.currentPage > 1;
    }

    public boolean isLast() {
        return this.pageCount <= this.currentPage;
    }

    public boolean isFirst() {
        return this.currentPage == 1;
    }

    public int[] getCurrentScope() {
        if (pageCount == 0) {
            return new int[] { 0, 0 };
        }

        int[] result = new int[2];

        if (this.currentPage > this.pageCount) {
            this.currentPage = this.pageCount;
        }

        result[0] = (this.currentPage - 1) * pageSize;
        result[1] = result[0] + pageSize;

        if (this.currentPage == this.pageCount) {
            result[1] = result[0] + this.lastPageSize;
        }

        return result;
    }

    public int getIntegerRecordCount() {
        return (int) this.recordCount;
    }
}
