package zyp.Thread;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

/**
 * @author zyp
 */
public class TestThread {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        ExecutorService executor1 = Executors.newFixedThreadPool(5);
        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
//            executor.execute(myTask);
            executor.submit(myTask);
            System.out.println("线 程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();


    }
}


class MyTask implements Callable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

//    @Override
//    public void run() {
//        System.out.println("正在执行task "+taskNum);
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("task "+taskNum+"执行完毕");
//    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
