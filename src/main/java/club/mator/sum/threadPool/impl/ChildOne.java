package club.mator.sum.threadPool.impl;

public class ChildOne implements Father {

    private volatile static int sum = 0;
    @Override
    public String call() {



        System.out.println("----------ChildOne-------------  "+sum);
        try {
            Thread.currentThread().sleep(100);
            //new Thread().sleep(100);
        }catch (Exception e){

            System.out.println("---ChildOne sleep error--");
        }


        sum++;

        return "one_child" + sum;
    }
}
