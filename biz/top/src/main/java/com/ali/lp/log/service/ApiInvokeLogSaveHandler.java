package com.ali.lp.log.service;

import com.ali.lp.log.BaseApiInvokeLog;

public interface ApiInvokeLogSaveHandler {
    void saveLog(BaseApiInvokeLog logData);
}
