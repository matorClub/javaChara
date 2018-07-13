package club.mator.sum.threadPool.impl;

public class ChildThree implements Father {

    @Override
    public String call() {

        System.out.println("----------ChildThree-------------  ");
        slep();

        return "three_child";
    }
}
