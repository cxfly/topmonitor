package com.ali.lp.log.service;

import java.util.Date;
import java.util.List;

import com.ali.lp.log.BaseApiInvokeLog;

public interface ApiInvokeLogService {
    boolean saveLog(BaseApiInvokeLog logData);
    List<?> queryLog(Date beginDate, Date endDate, String invokeApi, String invokeSource);
    boolean deleteLog(Date beginDate, Date endDate);
}
