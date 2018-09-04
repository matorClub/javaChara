package club.mator.sum.jvm.staticSafe;

/**
 * Created: 下午2:38-2018/8/20
 * author: feiFei.chen
 * desc: TODO Something
 * version: 1.0
 */
public class Father {
    static int i;
    private int j = 3;

     {
        System.out.println(i+++"---f1---");
    }

    static {
        System.out.println(i+++"---f2---");
    }
    Father(){
        System.out.println(j+++"---f3---");
    }

    Father(int k){

        System.out.println(i+k+++"---f4---");
    }



}
