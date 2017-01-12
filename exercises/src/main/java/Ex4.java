import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * @author victorp
 */
public class Ex4 {

    //Find how many Fridays the 13th of the month were since 1/1/1970 till now.

    public static int fridays13v1(){

        LocalDate date = LocalDate.ofEpochDay(0).with(nextOrSame(DayOfWeek.FRIDAY));
        LocalDate now = LocalDate.now();


        int count = 0;
        while (date.isBefore(now)){
            if (date.getDayOfMonth() == 13){
                count++;
            }
            date = date.with(next(DayOfWeek.FRIDAY));
        }


        return count;

    }

    public static int fridays13v2(){

            LocalDate seed = LocalDate.of(1970, Month.JANUARY, 13);
            LocalDate now = LocalDate.now();

            int count = 0;
            while (!seed.isAfter(now)) {
                if (seed.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    count++;
                }
                seed = seed.plusMonths(1);
            }
            return count;



        }



    public static void main(String... args){
        System.out.println("V1 - The number of Fridays 13 are:" + fridays13v1());
        System.out.println("V2 - The number of Fridays 13 are:" + fridays13v2());

    }
}
