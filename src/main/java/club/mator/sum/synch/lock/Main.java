package club.mator.sum.synch.lock;


import club.mator.sum.synch.AThred;
import club.mator.sum.synch.BThred;
import club.mator.sum.synch.Service;

import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created: 下午6:43-2018/7/10
 * auther: feifei.chen
 * desc:
 * version: 1.0
 */
public class Main {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            4,
            8,
            10,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>());

    public static void main(String[] args) throws Exception{
        Service lockServiceImpl1 = new LockServiceImpl();
        AThred a = new AThred(lockServiceImpl1);


        Service lockServiceImpl2 = new LockServiceImpl();
        BThred b = new BThred(lockServiceImpl2);

        FutureTask<String> tempTask1 = new FutureTask<String>(a);
        FutureTask<String> tempTask2 = new FutureTask<String>(b);



        threadPoolExecutor.execute(tempTask1);
//        tempTask2.cancel(true);
        threadPoolExecutor.execute(tempTask2);


    }
}
