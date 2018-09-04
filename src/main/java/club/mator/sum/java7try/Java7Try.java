package club.mator.sum.java7try;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created: 下午3:48-2018/7/13
 * auther: feifei.chen
 * desc:
 * version: 1.0
 *
 * 从上述代码我们可以观测四件事
 * 1. 凡是实现了AutoCloseable接口的类，在try()里声明该类实例的时候，在try结束后，close方法都会被调用
 * 2. try结束后自动调用的close方法，这个动作会早于finally里调用的方法。
 * 3. 不管是否出现异常（int i=1/0会抛出异常），try()里的实例都会被调用close方法
 * 4. 越晚声明的对象，会越早被close掉。
 *
 */
public class Java7Try {

    public static void main(String[] args) {

         File file = new File("");
        try (InputStream inputStream = new FileInputStream(file)) {

            inputStream.available();
        } catch (Exception e) {

        }
    }

}
