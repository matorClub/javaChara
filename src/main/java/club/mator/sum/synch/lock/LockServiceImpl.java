package club.mator.sum.synch.lock;

import club.mator.sum.synch.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created: 下午6:30-2018/7/10
 * auther: feifei.chen
 * desc:
 * version: 1.0
 */
public class LockServiceImpl implements Service {

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void SerA() {
        try {
            lock.lock();
            System.out.println("------------- 进锁----------");
            TimeUnit.SECONDS.sleep(5L);
            System.out.println("------------- chu锁----------");
            lock.unlock();
        }catch (Exception e){}
        finally {
            lock.unlock();
        }

    }

    @Override
    public void SerB() {

        try {
            lock.lockInterruptibly();// 注意这里，可以响应中断
            System.out.println("--------------B------------");
        }catch (Exception e){

            System.out.println("---中断--");
        }finally {
            lock.unlock();
        }

    }

    @Override
    public void sayHi() {

    }
}
