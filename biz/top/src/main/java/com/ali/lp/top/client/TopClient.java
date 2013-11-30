package com.ali.lp.top.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ali.lp.common.annotation.config.Config;
import com.ali.lp.top.mina.client.Simuliate;

@Component
public class TopClient {
    
    @SuppressWarnings("unused")
    @Config("max.random.sleep.time")
    private final int maxRandomSleepTime = 1;
    
    @Resource
    private Simuliate simuliate;
    
    /**
     * 模拟调用top平台
     * @return
     */
    public boolean execute() {
        boolean result = false;
        
        result = this.simuliate.simuliateInvoke();

        return result;
    }


    
    
    
    
}
