package club.mator.sum.synch.obj;

import bianlifeng.synch.AThred;
import bianlifeng.synch.BThred;
import bianlifeng.synch.Service;

import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created: 下午5:24-2018/7/10
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

    public static void main(String[] args) {
        Service objServiceImpl1 = new ObjServiceImpl();
        AThred a = new AThred(objServiceImpl1);


        Service objServiceImpl2 = new ObjServiceImpl();
        BThred b = new BThred(objServiceImpl2);

        FutureTask<String> tempTask1 = new FutureTask<String>(a);
        FutureTask<String> tempTask2 = new FutureTask<String>(b);
        FutureTask<String> tempTask3 = new FutureTask<String>(a);


        threadPoolExecutor.execute(tempTask1);
        threadPoolExecutor.execute(tempTask3);
        objServiceImpl2.sayHi();
//        objServiceImpl2.SerB();
        threadPoolExecutor.execute(tempTask2);

    }

}
