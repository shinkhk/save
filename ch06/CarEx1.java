package ch06;
//package com.naver.utile;

//클래스 선언 : ch06.Car1
//클래스 : 객체를 만드는 틀(ex-붕어빵 틀)
class Car1/*클래스명*/ {
	
	//필드 : 객체의 속성 <- 무조건 ()는 없다.
	String carName;
	int velocity;
	String carColor;
	
	//메서드 : 객체의 기능 <- 반드시 ()가 있다.
	void speedUp() {
		velocity++;
	}
	
	void speedDown() {
		velocity--;
		if(velocity<0)
			velocity = 0;
	}
	
	void stop() {
		velocity = 0;
	}
	
}//--class


//.java로 선언된 클래스만 public 사용가능
public class CarEx1 {

	public static void main(String[] args) {
		int arr[] = new int[3];
		//System.out.println(arr.length);
		String str = "오늘의 메뉴는 수구레";
		//System.out.println(str.length());
		
		//객체 생성
		Car1 c1;
		c1 = new Car1();
		c1.carName = "소나타";
		c1.carColor = "은색";
		c1.speedUp();
		
		System.out.println(c1.carName);
		System.out.println(c1.carColor);
		System.out.println(c1.velocity);
	}
}






