package club.mator.sum.synch;

import java.util.concurrent.Callable;

/**
 * Created: 下午5:20-2018/7/10
 * auther: feifei.chen
 * desc:
 * version: 1.0
 */
public class BThred implements Callable<String> {

    private Service objServiceImpl;


    public BThred(Service objServiceImpl){
        this.objServiceImpl = objServiceImpl;
    }

    @Override
    public String call(){
        try {
            objServiceImpl.SerB();
        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        return null;
    }

}
