package club.mator.sum.jvm;

import club.mator.common.Method;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Created: 下午1:36-2018/7/25
 * author: feiFei.chen
 * desc: TODO Something
 * version: 1.0
 */
public class MethodImpl implements Method {

    @Override
    public <S> S getT(S s) {

        return s;
    }

    @Override
    public <S> String getStr(S s) {
        return null;
    }

    @Override
    public <S> void getC(S s) {
         File flie = (File) s;
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(flie))){
            EntryJvm entry = EntryJvm.builder().name("chen___ff").build();
            out.writeObject(entry);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        File file = new File("/Users/bianlifeng/Desktop/g.log");

        new MethodImpl().getC(file);

    }
}
