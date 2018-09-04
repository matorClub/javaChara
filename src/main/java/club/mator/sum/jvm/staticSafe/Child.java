package club.mator.sum.jvm.staticSafe;

/**
 * Created: 下午2:42-2018/8/20
 * author: feiFei.chen
 * desc: TODO Something
 * version: 1.0
 */
public class Child extends Father{
        static int i;
        {
            System.out.println(i--+"---c1----");
        }

   static  {
        System.out.println(i--+"----c2----");
    }

    Child(){
            super(++i);
            System.out.println(--i+"----c3------");
    }
}
