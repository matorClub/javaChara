package club.mator.sum.synch.obj;
;
import club.mator.sum.synch.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created: 下午5:10-2018/7/10
 * auther: feifei.chen
 * desc:
 * version: 1.0
 */
public class ObjServiceImpl implements Service {

    private String lock = "lock";//一定要是同一个对象

    private int a = 1;


    @Override
    public void SerA() {

        if (a != 1){

            System.out.println("-------AAAAAA不进锁--------");
//            return;
        }
        a ++;
            synchronized (lock){// 用同一个对象时，多线程只执行一个线程
                try {
                    System.out.println("--------AAAAA--------");
                    TimeUnit.SECONDS.sleep(5L);//睡眠20
                    System.out.println("--------AAAAA--------END");
                }catch (Exception e){}

            }

    }



    @Override
    public void SerB(){

        synchronized (lock){

            try {
                System.out.println("-------BBBBB-------");
                TimeUnit.SECONDS.sleep(5L);//睡眠20
                System.out.println("--------BBBBB--------END");
            }catch (Exception e){}

        }

    }

    @Override
    public void sayHi() {
        System.out.println("------------hi--------");
    }
}
