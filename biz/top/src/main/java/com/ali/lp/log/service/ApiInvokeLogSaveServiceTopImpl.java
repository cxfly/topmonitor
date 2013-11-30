package com.ali.lp.log.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ali.lp.log.BaseApiInvokeLog;

@Service("ApiInvokeLogService")
public class ApiInvokeLogSaveServiceTopImpl implements ApiInvokeLogService {
	private static Logger logger = LoggerFactory.getLogger(ApiInvokeLogSaveServiceTopImpl.class);
    @Override
    public boolean saveLog(BaseApiInvokeLog logData) {
    	logger.info("Top 接口调用，开始保存数据" + logData);
    	logger.info("Top 接口调用，保存数据成功！！！");
        return true;
    }

    @Override
    public List<?> queryLog(Date beginDate, Date endDate, String invokeApi, String invokeSource) {
    	logger.info("Top 接口调用，开始保存数据");
        return null;
    }

    @Override
    public boolean deleteLog(Date beginDate, Date endDate) {
        // TODO Auto-generated method stub
        return false;
    }

}
