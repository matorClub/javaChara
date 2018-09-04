package club.mator.sum.jvm;

/**
 * Created: 下午8:29-2018/7/24
 * Auther: feifei.chen
 * desc:
 * version: 1.0
 */
public class ObjectSize {

    public static void main(String[] args) {
        System.out.println("--- Memory Usage:"); /*打印一行字符串---Memory Usage*/
        Runtime rt=Runtime.getRuntime( ); //获得系统的Runtime对象rt
//打印总内存大小 //打印空闲内存大小 //打印已用内存大小 单位(字节)
        System.out.println("Total Memory= " + rt.totalMemory()/(1048576)+

                " Free Memory = "+rt.freeMemory()/(1048576)+" Used　Memory="+(rt.totalMemory()-rt.freeMemory())/(1048576));
    }
}
