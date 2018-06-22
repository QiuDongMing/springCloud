package com.coderme.faq.service.impl;

import com.coderme.faq.service.AsyncTaskService;
import com.coderme.faq.service.ITestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * @author qiudm
 * @date 2018/6/21 16:04
 * @desc
 */
@Service
public class TestServiceImpl implements ITestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private AsyncTaskService asyncTaskService;

    @Override
    public void asyncTest(int count) {
        logger.info("async Test begin");

        logger.info("thread activeCount:{}", Thread.activeCount());

        asyncTaskService.asyncTask(1);
        asyncTaskService.asyncTask(2);
        asyncTaskService.asyncTask(3);
        asyncTaskService.asyncTask(4);
        asyncTaskService.asyncTask(5);
        asyncTaskService.asyncTask(6);


        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        Set<Map.Entry<Thread, StackTraceElement[]>> entries = allStackTraces.entrySet();
        int i = 0;
//        for (Map.Entry<Thread, StackTraceElement[]> entry : entries) {
//            ++i;
//            logger.info("key:{},val:{}", entry.getKey(), entry.getValue());
//        }

        logger.info("async Test end");
    }


}
