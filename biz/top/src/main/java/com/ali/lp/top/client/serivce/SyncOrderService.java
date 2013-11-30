package com.ali.lp.top.client.serivce;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ali.lp.top.client.TopClient;
import com.ali.lp.top.log.serivce.TopClientInvokeLogService;
import com.ali.lp.top.monitor.entity.TopClientMonitorInfo;

@Service("synOrderService")
public class SyncOrderService {
    public static final Logger LOG = LoggerFactory.getLogger(SyncOrderService.class);
    
    @Resource
    private TopClientInvokeLogService logService;
    
    @Resource
    private TopClient                 topClient;

    public void invoke(String worker) throws Exception {
//        logger.info("worker " + worker + " ---------->start invoke top client.....");
//        this.logService = TopClientInvokeLogService.getInstance();
//        this.topClient = new TopClient();
        TopClientMonitorInfo infokeInfo = new TopClientMonitorInfo();
        infokeInfo.setInvokeStartDate(new Date());
        boolean result = topClient.execute();
        infokeInfo.setInvokeEndDate(new Date());
        infokeInfo.setInvokeApi("A" + Math.round((new Random()).nextInt(9)));
        infokeInfo.setSuccessFlag(result? "0000" : "-1RRR");
        infokeInfo.setMemo(worker);
        if (result) {
            
            
//            System.out.println("VVVV01====>DB...save invoke info to db...");
            this.logService.saveSuccessLogToDB(infokeInfo);
        } else {
//            System.out.println("XXXX01====>DB...xsave invoke info to db..." );
            this.logService.saveErrorLogToDB(infokeInfo);
        }

//        LOG.info("==========>end invoke top client.....TTTTTTT");
    }

    public static void main(String[] arg) {
//        Random r = new Random();
//        for (int i = 0; i < 1000; i++) {
//            System.out.println(Math.round(r.nextInt(4)));
//        }
        System.out.println(Math.round((new Random()).nextInt(4)));
    }
}
