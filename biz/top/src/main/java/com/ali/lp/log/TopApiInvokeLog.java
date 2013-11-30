package com.ali.lp.log;

public class TopApiInvokeLog extends BaseApiInvokeLog {
    private static final long serialVersionUID = 5864584770569745832L;

    private String errorCode;
    private String errorInfo;
    private String subErrorCode;
    private String subErrorInfo;
    private String inputParam;
    private String queryParam;
    private String outputResult;
    
    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorInfo() {
        return errorInfo;
    }
    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
    public String getSubErrorCode() {
        return subErrorCode;
    }
    public void setSubErrorCode(String subErrorCode) {
        this.subErrorCode = subErrorCode;
    }
    public String getSubErrorInfo() {
        return subErrorInfo;
    }
    public void setSubErrorInfo(String subErrorInfo) {
        this.subErrorInfo = subErrorInfo;
    }
    public String getInputParam() {
        return inputParam;
    }
    public void setInputParam(String inputParam) {
        this.inputParam = inputParam;
    }
    public String getQueryParam() {
        return queryParam;
    }
    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }
    public String getOutputResult() {
        return outputResult;
    }
    public void setOutputResult(String outputResult) {
        this.outputResult = outputResult;
    }
	@Override
	public String toString() {
		return String
				.format("TopApiInvokeLog [errorCode=%s, errorInfo=%s, subErrorCode=%s, subErrorInfo=%s, inputParam=%s, queryParam=%s, outputResult=%s]",
						errorCode, errorInfo, subErrorCode, subErrorInfo,
						inputParam, queryParam, outputResult);
	}
}
