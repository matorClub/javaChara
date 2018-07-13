package club.mator.sum.java8.main;



import club.mator.sum.java8.entrys.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Lama {

    static List<Entry> entries = new ArrayList<>();

    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            8,
            8,
            10,
            TimeUnit.MINUTES,
            new LinkedBlockingQueue<Runnable>());


   static{


       entries.add(new Entry("s1", "22"));
       entries.add(new Entry("s2", "222"));
   }


    public static void main(String[] args) throws Exception{


        //-----------------------------集合相关----------------------------------------
        Set<String> ticketKeySet = entries.stream().map(Entry::getAge).collect(Collectors.toSet());

//        ticketKeySet.forEach(System.out::println);

        System.out.println("----");

//        List<String> ages = entries.stream().map(p->p.getAge()).filter(p-> !p.isEmpty()).collect(Collectors.toList());
        List<String> ages = entries.stream().map(Entry::getAge).filter(p-> !p.isEmpty()).collect(Collectors.toList());
//        ages.forEach(System.out::println);



//        Lmada表达式Entry::getName 调用该方法
        Map<String,Entry> entryMap = entries.stream().collect(Collectors.toMap(Entry::getName,va->va));

        entryMap.forEach((k,v) -> {
            System.out.print(k+"  ");
            System.out.println(v);
        });

//-----------------------------线程相关----------------------------------------
        Runnable r = () -> System.out.println("hello world");
        r.run();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("老方式创建线程");
            }
        }).start();

        new Thread(()-> System.out.println("新方式创建线程")).start();

        threadPoolExecutor.execute(()->{
            System.out.println("线程池的Lamada方式");
        });


        FutureTask<String> futureTask = new FutureTask(()->{
            System.out.println("======futureTask执行=====");
            return "futureTask模式创建线程";
        });
        threadPoolExecutor.execute(futureTask);
        threadPoolExecutor.execute(futureTask);

        System.out.println(futureTask.get());

        threadPoolExecutor.execute(new FutureTask(()->{
            return "futureTask模式创建线程 Lamada方式";
        }));


    }
}
