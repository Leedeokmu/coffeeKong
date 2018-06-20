package com.coffeekong;

import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
//        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy:MM:dd ");
        DateTimeFormatter dtf = DateTimeFormat.forPattern("HH:mm");
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy:MM:dd HH:mm");
        // time zone
//        DateTimeZone utc = DateTimeZone.forID("Asia/Seoul");
        DateTimeZone utc = DateTimeZone.forID("UTC");
        DateTimeZone kr = DateTimeZone.forID("Asia/Seoul");
//        DateTimeZone testZone = DateTimeZone.forID("Asia/Seoul");
        DateTimeZone testZone = DateTimeZone.forID("UTC");

        // current time
        DateTime curTime = (new DateTime()).withHourOfDay(3).withMinuteOfHour(20).toDateTime(testZone);
        // noticing time
        List<String> list = new ArrayList<>();
        list.add("14:30");
        list.add("23:30");
        list.add("06:30");
        list.add("02:30");
        list.add("18:30");
        list.add("09:30");
        list.add("12:30");
        list.add("13:30");

        List<String> timeList = new ArrayList<>();

        System.out.println("UTC : " + curTime.toDateTime(DateTimeZone.forID("UTC")).toString("HH:mm") + " KR : " + curTime.toDateTime(kr).toString("HH:mm"));
//        System.out.println("current time(full text) : " + curTime + "\n");
        System.out.println("test zone : " + testZone);
        System.out.println("current time : " + curTime.toDateTime(testZone).toString("yyyy:MM:dd HH:mm") + " (" + testZone + ")" + "\n");


        for(String timeString:list){
            String yyyyMMdd = curTime.toString("yyyy:MM:dd");
            DateTime tmpTime1 = dtf.parseDateTime(timeString).toDateTime(testZone);

            DateTime tmpTime2 = dateTimeFormatter.withZone(testZone).parseDateTime(yyyyMMdd + " " + tmpTime1.toString("HH:mm"));
//            System.out.println("UTC time : " + tmpTime2.toString("yyyy:MM:dd HH:mm"));
            if(tmpTime2.isBefore(curTime)){
                timeList.add(tmpTime2.toString("yyyy:MM:dd HH:mm"));
            }
        }
        for (String time : timeList) {
            System.out.printf("start list : %s\n", time);
        }
        System.out.println();

        DateTime targetTime = (new DateTime()).withHourOfDay(3).withMinuteOfHour(20).toDateTime(testZone).plusDays(2);
        int i = 1;
        while(curTime.isBefore(targetTime)){
            for(String timeString:list){
                String yyyyMMdd = curTime.toString("yyyy:MM:dd");
                DateTime tmpTime1 = dtf.parseDateTime(timeString).toDateTime(testZone);

                DateTime tmpTime2 = dateTimeFormatter.withZone(testZone).parseDateTime(yyyyMMdd + " " + tmpTime1.toString("HH:mm"));
                if(tmpTime2.isBefore(curTime) && !timeList.contains(tmpTime2.toString("yyyy:MM:dd HH:mm"))){
                    timeList.add(tmpTime2.toString("yyyy:MM:dd HH:mm"));
                    System.out.printf("notice time %d: %s current time : %s\n", i,  tmpTime2.toString("yyyy:MM:dd HH:mm"), curTime.toString("yyyy:MM:dd HH:mm"));
                    i++;
                }
            }
            curTime = curTime.plusMinutes(1);

        }
    }
}
