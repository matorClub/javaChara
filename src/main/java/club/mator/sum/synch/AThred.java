package club.mator.sum.synch;


import java.util.concurrent.Callable;

/**
 * Created: 下午5:17-2018/7/10
 * auther: feifei.chen
 * desc:
 * version: 1.0
 */
public class AThred implements Callable<String> {

    private Service testService;


    public AThred(Service objServiceImpl){
        this.testService = objServiceImpl;
    }

    @Override
    public String call() {

        try {
            testService.SerA();
        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        return null;
    }
}
