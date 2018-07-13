package club.mator.sum.synch.clas;



import club.mator.sum.synch.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created: 下午5:41-2018/7/10
 * auther: feifei.chen
 * desc:
 * version: 1.0
 */
public class ClasServiceImpl implements Service {

    private int a=1;

    @Override
    public void SerA() {
        synchronized (ClasServiceImpl.class){
            if (a != 1){

                System.out.println("-------AAAAAA不进锁--------");
                return;
            }
            a ++;
            try {
                System.out.println("--------AAAAAAAAAA--------");
                TimeUnit.SECONDS.sleep(5L);//睡眠20
                System.out.println("--------AAAAAAAAAA--------END");
            }catch (Exception e){}

        }
    }

    @Override
    public void SerB() {
        synchronized (ClasServiceImpl.class) {
            try {
                System.out.println("--------BBBBBBBB--------");
                TimeUnit.SECONDS.sleep(5L);//睡眠20
                System.out.println("--------BBBBBBBB--------END");
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void sayHi() {
        System.out.println("--------ClasServiceImpl----");
    }
}
