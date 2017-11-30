package com.study.java8.datatime;

import java.time.Clock;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author yk
 * @version 1.0 Date: 11/9/17
 */
public class a1 {
    public static void main(String[] args) {
        Clock clock = Clock.systemUTC();
        LocalDate nowDate = LocalDate.now(clock);
        LocalDate prevYear = nowDate.minus(1, ChronoUnit.YEARS);
        LocalDate nextYear = nowDate.plus(1, ChronoUnit.YEARS);
        System.out.println(prevYear);
        System.out.println(nowDate);
        System.out.println(nextYear);
        System.out.println(new Date().getTime());
        System.out.println(clock.millis());

        LocalDate date = LocalDate.of(nowDate.getYear(), nowDate.getMonth(), 15);
        System.out.println(nowDate.isAfter(date));
    }
}
