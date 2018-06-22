package com.coderme.demo.jdk.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * @author qiudm
 * @date 2018/6/20 17:22
 * @desc
 */
public class ThreadPoolTest {

    @Test
    public void threadTest() {
        final  String keys = "ke";
            @SuppressWarnings("unchecked")
            Future<String> future = ThreadPoolsManager.getInstance().addExecuteTask(new Callable() {
                public Object call() throws Exception {
                    Thread.sleep(3000L);
                    int a = 1 / 0;
                    return getKey(keys);
                }
            });

            try {
                String s = null;
                s = future.get();//该方法造成阻塞，等待获取到值
                System.out.println("s = " + s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        System.out.println("future = " +  keys);

    }


    public String getKey(String key) {
        return key;
    }



}
