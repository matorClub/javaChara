package club.mator.sum.synch.clas;


import club.mator.sum.synch.AThred;
import club.mator.sum.synch.BThred;
import club.mator.sum.synch.Service;

import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created: 下午5:47-2018/7/10
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
        Service clasServiceImpl1 = new ClasServiceImpl();
        AThred a = new AThred(clasServiceImpl1);


        Service clasServiceImpl2 = new ClasServiceImpl();
        BThred b = new BThred(clasServiceImpl2);

        FutureTask<String> tempTask1 = new FutureTask<String>(a);
        FutureTask<String> tempTask3 = new FutureTask<String>(a);
        FutureTask<String> tempTask2 = new FutureTask<String>(b);



        threadPoolExecutor.execute(tempTask1);
        threadPoolExecutor.execute(tempTask3);
        threadPoolExecutor.execute(tempTask2);
//        TimeUnit.SECONDS.sleep(3L);//睡眠20
//        clasServiceImpl2.SerB();
        clasServiceImpl2.sayHi();

    }
}
