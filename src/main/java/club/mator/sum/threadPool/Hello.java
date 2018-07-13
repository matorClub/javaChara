package club.mator.sum.threadPool;


import club.mator.sum.threadPool.impl.ChildOne;
import club.mator.sum.threadPool.impl.ChildThree;
import club.mator.sum.threadPool.impl.ChildTwo;
import club.mator.sum.threadPool.impl.Father;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Hello {

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            4,
            8,
            10,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>());

    private static List<Callable<String>> callables = new LinkedList<Callable<String>>();
    private static List<FutureTask<String>> futureTasks = new LinkedList<FutureTask<String>>();

    public static void main(String [] args){
        getCallables();

        callables.forEach(ta->{
            FutureTask<String> tempTask = new FutureTask<String>(ta);
            futureTasks.add(tempTask);

        });
        futureTasks.forEach(task->threadPoolExecutor.execute(task));

        threadPoolExecutor.shutdownNow();
        getResult();
        System.out.println("hello world");
    }

    public static void getCallables(){
        Father fa = new ChildOne();
        System.out.println("----打印----");
        callables.add(fa);
        callables.add(new ChildTwo());
        callables.add(new ChildThree());
        callables.add(fa);



    }

    private static void getResult() {

        futureTasks.forEach(task->{
            try {
                System.out.println(task.get());
            }catch (Exception e){
                System.out.println("----error----");
            }
        });

    }
}
