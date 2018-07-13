package club.mator.sum.threadPool.impl;

public class ChildTwo implements Father {

    @Override
    public String call() {
        System.out.println("----------ChildTwo-------------  ");
        slep();


        return "two_child";
    }
}
