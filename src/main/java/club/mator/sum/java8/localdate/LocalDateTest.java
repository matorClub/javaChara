package club.mator.sum.java8.localdate;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created: 下午8:46-2018/7/17
 * auther: feifei.chen
 * desc:
 * version: 1.0
 */
public class LocalDateTest {



    public static void main(String[] args) {

        Date date = new Date();

        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate da = LocalDate.of(2007,01,23);
//        LocalDate da2 = da.plusDays(10);
//
//        System.out.println(da2);
//        Date input = new Date();
//        LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

//        或者

        System.out.println(localDate);

    }

    void getC(){
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);

        Date date = Date.from(zdt.toInstant());
    }
}
