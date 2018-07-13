package club.mator.sum.threadPool.impl;

import java.util.concurrent.Callable;

public interface Father extends Callable<String> {


    default void slep(){

        try {
//            new Thread().sleep(5000);
        }catch (Exception e){

            System.out.println("---Father sleep error--");
        }

    }
}
