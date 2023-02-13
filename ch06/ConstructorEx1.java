package ch06;

class Constructor1 extends Object{
	
	//디폴트 생성자 : 구현하지 않으면 JVM 컴파일 시점에 제공
	public Constructor1() {
		System.out.println("생성자 호출");
	}
	
	public Constructor1(int i) {
		System.out.println("매개변수 int 생성자 호출");
	}
	
	public Constructor1(String s) {
		System.out.println("매개변수 String 생성자 호출");
	}
	
}

public class ConstructorEx1 {

	public static void main(String[] args) {
		//생성자가 많이 존재하는 이유 : 객체가 생성되는 다양한 case
		Constructor1 c1 = new Constructor1();
		Constructor1 c2 = new Constructor1(22);
		Constructor1 c3 = new Constructor1("하하");
		
	}
}





