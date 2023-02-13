package ch09;

class Outer2{
	
	int a = 22;
	
	void p() {
		System.out.println("a : " + a);
		//System.out.println("a + b  = " + (a + b));
		//내부클래스는 외부클래스 내에서만 일반적으로 사용을 하고
		//상당히 밀접한 관계가 있는 기능의 클래스로 선언
	}
	
	class Inner2{
		int b = 23;
		void p1() {
			p();
			System.out.println("a + b  = " + (a + b));
		}
	}//--Inner2
}

public class InnerEx2 {
	public static void main(String[] args) {
		//일반적으로 내부클래스는 다른 클래스에서 생성하고 사용하는것은 거의 없음
		//제3의 클래스에 사용법
		Outer2 out = new Outer2();
		Outer2.Inner2 in = out.new Inner2();
		in.p1();
	}
}







