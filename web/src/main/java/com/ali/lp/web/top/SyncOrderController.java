package com.ali.lp.web.top;

import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ali.lp.log.ApiInvokeLogQueue;
import com.ali.lp.log.BaseApiInvokeLog;
import com.ali.lp.log.TopApiInvokeLog;
import com.ali.lp.log.TopInvokeLogService;
import com.ali.lp.top.entity.TopInvokeSuccessLog;
import com.ali.lp.top.log.serivce.TopClientInvokeLogService;
import com.ali.lp.top.monitor.SyncOrderWorkerExecutor;
import com.ali.lp.top.monitor.entity.TopClientMonitorInfo;
import com.ali.lp.top.monitor.entity.TopInvokeSuccessBean;

@Controller
@RequestMapping(value = "/syncOrder/*")
public class SyncOrderController {

    public SyncOrderController() {
        super();
    }

    @Resource
    private SyncOrderWorkerExecutor   syncOrderWorkerExecutor;
    @Resource
    private TopClientInvokeLogService logService;

    @Resource
    private TopInvokeLogService       topInvokeLogService;

    @RequestMapping(method = RequestMethod.GET, value = "/execute")
    public String execute(Model model, HttpServletRequest request, HttpServletResponse response,
                          @RequestParam(value = "task", required = true) String taskName) {
        boolean result = false;
        StopWatch watch = new StopWatch();
        try {
            watch.start(taskName);
            result = this.syncOrderWorkerExecutor.process(taskName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        watch.stop();
        String summary = watch.prettyPrint();
        model.addAttribute("result", result);
        model.addAttribute("summary", summary);

        long errorCount = this.logService.getTopInvokeErrorRowCount();
        long succCount = this.logService.getTopInvokeSuccRowCount();
        long cacheSuccCount = this.logService.getCacheTopInvokeSuccRowCount();
        long allCount = errorCount + succCount + cacheSuccCount;
        model.addAttribute("errorCount", errorCount);
        model.addAttribute("succCount", succCount);
        model.addAttribute("cacheSuccCount", cacheSuccCount);
        model.addAttribute("allCount", allCount);

        return "main.layout";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/flush")
    public String flush(Model model, HttpServletRequest request, HttpServletResponse response) {
        boolean result = false;
        StopWatch watch = new StopWatch();
        try {
            result = this.logService.saveCacheAllSuccessLogToDB();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("result", result);
        model.addAttribute("summary", watch.prettyPrint());

        long errorCount = this.logService.getTopInvokeErrorRowCount();
        long succCount = this.logService.getTopInvokeSuccRowCount();
        long cacheSuccCount = this.logService.getCacheTopInvokeSuccRowCount();
        long allCount = errorCount + succCount + cacheSuccCount;
        model.addAttribute("errorCount", errorCount);
        model.addAttribute("succCount", succCount);
        model.addAttribute("cacheSuccCount", cacheSuccCount);
        model.addAttribute("allCount", allCount);

        return "main.layout";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/testTa")
    public String testTa(Model model, HttpServletRequest request, HttpServletResponse response) {

        try {
            TopClientMonitorInfo infokeInfo = new TopClientMonitorInfo();
            infokeInfo.setInvokeStartDate(new Date());
            boolean result = false;
            infokeInfo.setInvokeEndDate(new Date());
            infokeInfo.setInvokeApi("A" + Math.round((new Random()).nextInt(9)));
            infokeInfo.setSuccessFlag(result ? "0000" : "-1RRR");
            infokeInfo.setMemo("test");
            this.logService.addErrorLogToDB(infokeInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "main.layout";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String push(Model model, HttpServletRequest request, HttpServletResponse response,
                       @RequestParam(value = "src", required = true) String invokeSrc) {
        boolean result = false;
        try {
            BaseApiInvokeLog log = new TopApiInvokeLog();
            log.setId(234);
            log.setStartTime(new Date());
            log.setEndTime(new Date());
            log.setInvokeSource(invokeSrc);
            result = ApiInvokeLogQueue.getInstance().push(log);
            result = this.topInvokeLogService.log(log);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        model.addAttribute("result", result);

        return "main.layout";
    }

    @ResponseBody
    @RequestMapping(value = "/getLog/{id}")
    public TopInvokeSuccessLog getInvokeSuccessLog(@PathVariable("id") Long id) {
        TopInvokeSuccessLog topInvokeSuccessLog = this.logService.getTopInvokeSuccessLog(id);
        System.out.println(topInvokeSuccessLog);
        return topInvokeSuccessLog;
    }
    
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/saveLog")
    public String saveLog(@RequestBody TopInvokeSuccessBean successInfo) {
        System.out.println(successInfo);
        this.logService.saveSuccessInfoToDB(successInfo);
        return "OK";
    }

}
