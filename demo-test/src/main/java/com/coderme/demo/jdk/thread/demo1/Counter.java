package com.coderme.demo.jdk.thread.demo1;

import com.coderme.demo.jdk.thread.ThreadPoolsManager;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author qiudm
 * @date 2018/6/25 11:43
 * @desc
 */


public class Counter {

    public static int num = 0;

    public static int inr() {
        System.out.println("num = " + num);
        num++;
        return num;

    }

    public static void main(String[] args) {
        Future future = ThreadPoolsManager.getInstance().addExecuteTask(
                ()->inr()
        );

        try {
            System.out.println("future = " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }




}






