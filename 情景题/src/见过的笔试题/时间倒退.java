package 见过的笔试题;

import java.util.Scanner;

public class 时间倒退 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dayNow = sc.nextInt();
        String time = sc.next();
        int minute = sc.nextInt();
        String[] split = time.split(":");

        //当前时间
        int timeNow = Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        //倒退后的时间
        int timeBefore = timeNow - minute;
        //倒退天数
        int days = timeBefore / 1440;
        if (timeBefore < 0) {
            days += 1;
        }
        //在当天的值
        int thatDayTime = timeBefore % 1440;
        thatDayTime = thatDayTime >= 0 ?  thatDayTime : 1440 + thatDayTime;

        int thatDay = (dayNow + 7 - days) % 7;
        if (thatDay==0){
            thatDay=7;
        }
        int thatDayhours = thatDayTime / 60;
        int thatDayMinutes = thatDayTime % 60;

        String outHour;
        String outMinute;

        outHour=String.valueOf(thatDayhours);
        outMinute=String.valueOf(thatDayMinutes);

        if (thatDayhours == 24) {
            outHour = "00";
        }
        if (thatDayhours < 10) {
            outHour = "0" + outHour;
        }
        if (thatDayMinutes < 10) {
            outMinute = "0" + outMinute;
        }

        System.out.println(thatDay);
        System.out.println(outHour + ":" + outMinute);

    }
}
