package club.mator.sum.arithmetic;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created: 下午3:23-2018/8/20
 * author: feiFei.chen
 * desc: excel 行数生成策略
 * version: 1.0
 */
public class ExcelRow {

    private static char A = 'A';
    private static int begin = A;

    public static void main(String[] args) {
        int a = 26+3;

        List<Integer> rowNum = getList(a);
        List<Character> list = toString(rowNum);
        list.forEach(System.out::print);

    }

    /**
     *十进制转26进制数组
    */
    private static List<Integer> getList(int rowNum){

        List<Integer> rowList = Lists.newLinkedList();
        while (rowNum / 26 > 0){

            rowList.add(rowNum % 26);
            rowNum = rowNum / 26;
        }

        rowList.add(rowNum);
        return rowList;
    }

    /**
     *数字转字符
     */
    private static List<Character> toString(List<Integer> rowList){

        rowList.forEach(System.out::println);

        List<Character> result = Lists.newLinkedList();
        rowList.forEach(p->result.add((char) (p + begin)));

        return result;
    }


}
