import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;

/**
 * @author victorp
 */
public class Sample8DateAndTime {

    public static void main(String... args){

        /**
         * now
         * LocalDate
         * LocalTime
         * LocalDateTime
         */
//
//        LocalDate today = LocalDate.now();
//        LocalTime currentTime = LocalTime.now();
//        LocalDateTime now = today.atTime(currentTime);
//
//        Util.println("today is: "+ today);
//        Util.println("the current time is: "+ currentTime);
//        Util.println("now is: "+ now);
//
//        Util.println("and now is: "+ LocalDateTime.now());


        /**
         * create date and time from ...
         * LocalDate
         * LocalDate
         * LocalDateTime
         */

//        LocalDate april30_2020 = LocalDate.of(2020, Month.JUNE,30);
//        Util.println(april30_2020);
//
//        LocalTime midnight30 = LocalTime.of(0, 33);
//        Util.println(midnight30);
//
//        Util.println(midnight30.atDate(april30_2020));


        /**
         * With absolute hour
         */
//        Util.println(LocalDateTime.now().withHour(1));


        /**
         * With relative hour
         */
//        Util.println(LocalDateTime.now().plusHours(1));

        /**
         * Machine representation (no time zone info)
         */
//        Instant epochMillis = Instant.ofEpochMilli(0);
//        Util.println("Instant epoch date: " + LocalDateTime.ofInstant(epochMillis, ZoneId.systemDefault())) ;
//        Util.println("Instant now: " + Instant.now()) ;


        /**
         * ZonedDateTime
         * http://www.iana.org/time-zones
         */
//        ZonedDateTime zonedNow = ZonedDateTime.now();
//        Util.println("ZonedDateTime now: " + zonedNow);
//
//
//        ZonedDateTime romeTimeNow = zonedNow.withZoneSameInstant(ZoneId.of("Europe/Rome"));
//        Util.println("Rome time now: "+ romeTimeNow);
//


        /**
         * TemporalAdjusters
         */
//        ZonedDateTime lastSundayThisMonth = ZonedDateTime.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
//        Util.println(lastSundayThisMonth);



        /**
         * Exercise Ex4
         */








    }

}
