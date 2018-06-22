package com.coderme.faq.service;

import com.coderme.faq.service.impl.TestServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author qiudm
 * @date 2018/6/21 16:55
 * @desc
 */
@Service
public class AsyncTaskService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTaskService.class);

    @Async
    public void asyncTask(int i)  {
        for (int j = 0; j < 1; j++) {
            try {
//                Thread.sleep(2000L);
                logger.info("current thread:{},async task :{}",Thread.currentThread().getName(), i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Async
    public void innerAsync(){
        logger.info("innner async current thread:{}",Thread.currentThread().getName());
    }


}
