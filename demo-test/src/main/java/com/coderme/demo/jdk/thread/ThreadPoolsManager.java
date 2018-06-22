package com.coderme.demo.jdk.thread;

import java.util.concurrent.*;

/**
 * @author qiudm
 * @date 2018/6/20 16:56
 * @desc
 */
public class ThreadPoolsManager {

    private static ThreadPoolsManager threadManager = null;

    /**
     * 核心线程数，默认情况下核心线程会一直存活，
     * 即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
     */
    private static final int corePoolSize = 2;

    /**
     * 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。
     * 当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效
     */
    private static final int maximumPoolSize = 20;

    /**
     * 存活时间
     */
    private static final long keepAliveTime = 30;



    private ThreadPoolsManager() {
    }

    public static ThreadPoolsManager getInstance() {
        if (threadManager == null) {
            synchronized (ThreadPoolsManager.class) {
                if (threadManager == null) {
                    threadManager = new ThreadPoolsManager();
                }
            }
        }
        return threadManager;
    }


    private final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize,
            maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());



    public Future addExecuteTask(Callable callable) {
        return threadPool.submit(callable);
    }


    public void execute(Runnable runnable) {
        threadPool.execute(runnable);
    }




}
