package com.ali.lp.top.log.serivce;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.hibernate.PropertyValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ali.lp.common.annotation.config.Config;
import com.ali.lp.top.dao.TopInvokeErrorLogDao;
import com.ali.lp.top.dao.TopInvokeSuccessLogDao;
import com.ali.lp.top.entity.TopInvokeErrorLog;
import com.ali.lp.top.entity.TopInvokeSuccessLog;
import com.ali.lp.top.monitor.entity.TopClientMonitorInfo;
import com.ali.lp.top.monitor.entity.TopInvokeSuccessBean;


/**
 * top接口调用日志处理
 * @author lz
 *
 */
@Service("logService")
public class TopClientInvokeLogService {
    
    public static TopClientInvokeLogService logService;
    private static final Map<String,TopInvokeSuccessBean> cacheData = new ConcurrentHashMap<String,TopInvokeSuccessBean>();
    public static final Logger LOG = LoggerFactory.getLogger(TopClientInvokeLogService.class);
    private final byte[] lock = new byte[0];
    
    @Config("")
    private long cacheInvokeTimesSize;
    
    @Resource(name="topInvokeSuccessLogIbatisDao")
    private TopInvokeSuccessLogDao<TopInvokeSuccessLog> topInvokeSuccessLogDao;
    
    //topInvokeErrorLogIbatisDao
    @Resource(name="topInvokeErrorLogDao")
    private TopInvokeErrorLogDao<TopInvokeErrorLog> topInvokeErrorLogDao;
    
    public TopClientInvokeLogService() {}
    
    public static TopClientInvokeLogService getInstance() {
        if (logService == null) {
            LOG.info("constructor instance...");
            logService = new TopClientInvokeLogService();
        }
        return logService;
    }
    
    public void saveSuccessLogToDB(TopClientMonitorInfo infokeInfo) {
        //System.out.println("VVVV03====>DB...save invoke info to db...");
        String apiName = infokeInfo.getInvokeApi();
        
        synchronized (lock) {
            Date now = new Date();
            TopInvokeSuccessBean successInfo = cacheData.get(apiName);
            
            if (successInfo == null) {
                successInfo = new TopInvokeSuccessBean(apiName, 0, now);
                cacheData.put(apiName, successInfo);
            }

            // 更新cache中的数据至db
            Date invokeEndDate = successInfo.getLastModifyDate();
            if ((!isInToday(invokeEndDate, now) && successInfo.getTimes() > 0) // 最后一次调用日期不为当日
                    || (successInfo.getTimes() >= cacheInvokeTimesSize)) { // 调用次数是否超出限制
                this.saveSuccessInfoToDB(successInfo);
                this.resetData(successInfo, apiName, now);
            }
            
            // 调用次数增加并更新最后一次调用时间
            successInfo.addSuccessTimes(now); 
        }

    }
    
    
    public void saveErrorLogToDB(TopClientMonitorInfo invokeInfo) {
        TopInvokeErrorLog topInvokeErrorLog = new TopInvokeErrorLog();
        topInvokeErrorLog.setBeforeCheckFlag(invokeInfo.getBeforeCheckFlag());
        topInvokeErrorLog.setCheckResult(invokeInfo.getCheckResult());
        topInvokeErrorLog.setErrorCode(invokeInfo.getErrorCode());
        topInvokeErrorLog.setErrorMsg(invokeInfo.getErrorMsg());
        topInvokeErrorLog.setInvokeApi(invokeInfo.getInvokeApi());
        topInvokeErrorLog.setInvokeStartDate(invokeInfo.getInvokeStartDate());
        topInvokeErrorLog.setInvokeEndDate(invokeInfo.getInvokeEndDate());
        topInvokeErrorLog.setMemo(invokeInfo.getMemo());
        topInvokeErrorLog.setOutputResult(invokeInfo.getOutputResult());
        topInvokeErrorLog.setParamIn(invokeInfo.getParamIn());
        topInvokeErrorLog.setParamquery(invokeInfo.getParamQuery());
        topInvokeErrorLog.setSecret(invokeInfo.getSecret());
        topInvokeErrorLog.setSubErrorCode(invokeInfo.getSubErrorCode());
        topInvokeErrorLog.setSubErrorMsg(invokeInfo.getSubErrorMsg());
        topInvokeErrorLog.setTopUrl(invokeInfo.getTopUrl());
        topInvokeErrorLog.setSuccessFlag("错误");
        topInvokeErrorLog.setAppKey(invokeInfo.getAppKey());
        this.topInvokeErrorLogDao.save(topInvokeErrorLog);
        
        LOG.debug("--------------------------begin insert into second record----------------------------------------");
        topInvokeErrorLog.setCheckResult("OK");
        topInvokeErrorLog.setSuccessFlag("OKK");
        this.topInvokeErrorLogDao.save(topInvokeErrorLog);
        
        /*if ("abc".equals("abc")) {
        	throw new PropertyValueException("md", "tb", "test");
		} else {
			throw new RuntimeException("XXXXXX");
		}*/
    }
    public void addErrorLogToDB(TopClientMonitorInfo invokeInfo) {
    	TopInvokeErrorLog topInvokeErrorLog = new TopInvokeErrorLog();
    	topInvokeErrorLog.setBeforeCheckFlag(invokeInfo.getBeforeCheckFlag());
    	topInvokeErrorLog.setCheckResult(invokeInfo.getCheckResult());
    	topInvokeErrorLog.setErrorCode(invokeInfo.getErrorCode());
    	topInvokeErrorLog.setErrorMsg(invokeInfo.getErrorMsg());
    	topInvokeErrorLog.setInvokeApi(invokeInfo.getInvokeApi());
    	topInvokeErrorLog.setInvokeStartDate(invokeInfo.getInvokeStartDate());
    	topInvokeErrorLog.setInvokeEndDate(invokeInfo.getInvokeEndDate());
    	topInvokeErrorLog.setMemo(invokeInfo.getMemo());
    	topInvokeErrorLog.setOutputResult(invokeInfo.getOutputResult());
    	topInvokeErrorLog.setParamIn(invokeInfo.getParamIn());
    	topInvokeErrorLog.setParamquery(invokeInfo.getParamQuery());
    	topInvokeErrorLog.setSecret(invokeInfo.getSecret());
    	topInvokeErrorLog.setSubErrorCode(invokeInfo.getSubErrorCode());
    	topInvokeErrorLog.setSubErrorMsg(invokeInfo.getSubErrorMsg());
    	topInvokeErrorLog.setTopUrl(invokeInfo.getTopUrl());
    	topInvokeErrorLog.setSuccessFlag("错误");
    	topInvokeErrorLog.setAppKey(invokeInfo.getAppKey());
    	this.topInvokeErrorLogDao.save(topInvokeErrorLog);
    	
    	LOG.debug("--------------------------begin insert into second record----------------------------------------");
    	topInvokeErrorLog.setCheckResult("OK");
    	topInvokeErrorLog.setSuccessFlag("OKK");
    	this.topInvokeErrorLogDao.save(topInvokeErrorLog);
    	
    	if (!"abc".equals("abc")) {
    		throw new PropertyValueException("md", "tb", "test");
    	} else {
    		throw new RuntimeException("XXXXXX");
    		
    	}
    }
    
    public boolean saveCacheAllSuccessLogToDB() {
        Date now = new Date();
        for (Map.Entry<String, TopInvokeSuccessBean> entry : cacheData.entrySet()) {
            TopInvokeSuccessBean successInfo = entry.getValue();
            synchronized (lock) {
                if (successInfo.getTimes() > 0) {
                    this.saveSuccessInfoToDB(entry.getValue());
                    this.resetData(entry.getValue(), entry.getKey(), now);
                }
            }
        }

        return true;
    }
    
    public void saveSuccessInfoToDB(TopInvokeSuccessBean successInfo) {
        int rowNum = this.topInvokeSuccessLogDao.updateSuccessLog(successInfo.getApiName(),
                successInfo.getLastModifyDate(), successInfo.getTimes());
        if (rowNum == 0) {
            TopInvokeSuccessLog topInvokeSuccessLog = new TopInvokeSuccessLog();
            topInvokeSuccessLog.setApiName(successInfo.getApiName());
            topInvokeSuccessLog.setCreateDate(new Date());
            topInvokeSuccessLog.setLastModifyDate(successInfo.getLastModifyDate());
            topInvokeSuccessLog.setTimes(successInfo.getTimes());
            this.topInvokeSuccessLogDao.save(topInvokeSuccessLog);
        }
        // System.out.println("VVVV06====>DB...save invoke info to db...");
    }
    
    public TopInvokeSuccessLog getTopInvokeSuccessLog(Long id) {
        TopInvokeSuccessLog topInvokeSuccessLog = this.topInvokeSuccessLogDao.get(id);
        return topInvokeSuccessLog;
    }
    
    public TopInvokeSuccessBean resetData(TopInvokeSuccessBean data, String apiName, Date date) {
        data.setApiName(apiName);
        data.setTimes(0);
        data.setLastModifyDate(date);
        return data;
    }
    
    
    private boolean isInToday(Date date, Date now) {
        boolean result = false;
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        Calendar b =  Calendar.getInstance();
        b.setTime(now);
        if (c.get(Calendar.DATE) == b.get(Calendar.DATE)) {
            result = true;
        }
        return result;
    }
    
    
    public long getCacheTopInvokeSuccRowCount() {
        long result = 0;
        for (Map.Entry<String, TopInvokeSuccessBean> entry : cacheData.entrySet()) {
            TopInvokeSuccessBean successInfo = entry.getValue();
            synchronized (lock) {
                result += successInfo.getTimes();
            }
        }
        return result;
    }
    public long getTopInvokeErrorRowCount() {
       return this.topInvokeErrorLogDao.getTopInvokeErrorRowCount();
    }
    public long getTopInvokeSuccRowCount() {
        return this.topInvokeSuccessLogDao.getTopInvokeSuccessRowCount();
    }
}
