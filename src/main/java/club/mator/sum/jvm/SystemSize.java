package club.mator.sum.jvm;

import java.io.*;

/**
 * Created: 上午10:48-2018/7/25
 * author: feiFei.chen
 * desc:  计算内存占用量
 * version: 1.0
 */
public class SystemSize {



    public static void main(String[] args) {

        File file = new File("/Users/bianlifeng/Desktop/g.log");
        out(file);
        in(file);

    }


    private static String out(File file){

        try(ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(file))){

            objectOut.write(new String("chen_ff").getBytes());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    private static String in(File file){

        try (InputStream in = new FileInputStream(file)){

            byte [] bytes = new byte[7];
            int a = in.read();
            System.out.println(a);
            in.read(bytes);
            System.out.println(new String(bytes));
        }catch (Exception e){

        }

        return null;
    }

}
