package ch06;

/*클래스 선언 -> 필드&메서드 -> 
객체생성(new , 필드 및 메서드 사용)*/
class Car2{
	
	void stop() {
		speed = 0;
	}
	
	String name;
	int speed;
	int gear;
}

public class CarEx2 {
	public static void main(String[] args) {
		int a = 10;
		int b = a + 10;
		for (int i = 0; i < 100; i++) {
			Car2 c1 = new Car2();
			//System.out.println(c1.toString());
		}
		//요청값 소문자 -> 대문자 출력
		 String s = new String("adfgrregagr");
		 System.out.println(s.toUpperCase());
		 
		 //32라는 10진수를 2진수로 출력하세요.
		 //Hint : Integer : 정수를 객체화 시킨 클래스
		 Integer i = new Integer(32);
		 String str = i.toBinaryString(32);
		 System.out.println(str);
		 
	}
}





