package ch11;

import java.util.Calendar;

public class CalendarEx1 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.print("오늘의 날짜는 ");
		System.out.print(cal.get(Calendar.YEAR)+"년 ");
		System.out.print(cal.get(Calendar.MONTH)+1+"월 ");
		System.out.print(cal.get(Calendar.DATE)+"일 ");
		System.out.println();
		int hour = cal.get(Calendar.HOUR);
		int min = cal.get(Calendar.MINUTE);
		int sec = cal.get(Calendar.SECOND);
		int ampm = cal.get(Calendar.AM_PM);
		if(ampm==Calendar.AM)
			System.out.print("현재 시간은 AM ");
		else
			System.out.print("현재 시간은 PM ");
		System.out.println(hour +"시 " + min +"분 " + sec +"초");
		
	}

}



