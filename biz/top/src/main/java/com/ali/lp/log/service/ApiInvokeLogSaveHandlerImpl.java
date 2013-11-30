package com.ali.lp.log.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ali.lp.log.BaseApiInvokeLog;

@Service("apiInvokeLogSaveHandler")
public class ApiInvokeLogSaveHandlerImpl implements ApiInvokeLogSaveHandler {
	private static Logger logger = LoggerFactory.getLogger(ApiInvokeLogSaveHandlerImpl.class);
	private Map<String, ApiInvokeLogService> serviceMap = new HashMap<String,ApiInvokeLogService>();
	
	@Resource
	private ApiInvokeLogService apiInvokeLogService;
    @Override
    public void saveLog(BaseApiInvokeLog logData) {
    	logger.info("开始调用保存处理类...");
//    	ApiInvokeLogService apiInvokeLogService = this.serviceMap.get(logData.getInvokeSource());
    	apiInvokeLogService.saveLog(logData);
    }

	public Map<String, ApiInvokeLogService> getServiceMap() {
		return serviceMap;
	}

	public void setServiceMap(Map<String, ApiInvokeLogService> serviceMap) {
		this.serviceMap = serviceMap;
	}

}
