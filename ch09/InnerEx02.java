package ch09;

public class InnerEx02 {

class Outer2{
	
	int a = 22;
	
	void p () {
		System.out.println("a "+a);
//		System.out.println("a + b =" + (a+b)); 오류 내부클래스의 변수를 외부클래스가 쓸수없음
//		내부클래스는 외부클래스 내에서만 일반적으로 사용을 하고
//		
	}
	
	class Inner2{
		int b = 23;
		void p1() {
			p();
			System.out.println("a + b =" + (a+b));
		}
	}
	
}
	
	public static void main(String[] args) {
//		일반적으로 내부 클래스는 다른 클래스에서 생성하고 사용하는것은 거의 없음	
//		제3의 클래스에 사용법
	
	}

}
