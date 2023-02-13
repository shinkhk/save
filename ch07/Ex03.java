package ch07;

class Car3{
	public Car3() {
		super();
	}
	
	void speedUp() {
		
	}
}


class Taxi3 extends Car3{
	void stop() {
		
	}
}

public class Ex03 {

	public static void main(String[] args) {
		Object obj = new Car3();
//		obj.speedUp()				레퍼런스값은 받아올수있지만 하위객체의 메소드는 쓸수없다
		
		Car3 c = new Taxi3();
//		Taxi3 t = new Car3();		하위객체가 상위객체를 받아올수 없다
	}

}
