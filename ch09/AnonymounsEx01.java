package ch09;

interface MyInter1{
	void prn();
}

abstract class MyAbs1{
	abstract void prn();
}

class A implements MyInter{
	@Override
	public void prn() {
	System.out.println("일반적인 구현방법");
	}
}

class B extends MyAbs1{
	@Override
	void prn() {
	System.out.println("아니야");
	}
}

public class AnonymounsEx01 {

	public static void main(String[] args) {
		A a = new A();
		a.prn();
		B b = new B();
		b.prn();
		
		
	//MyInter을 다른 곳에서 가 아닌 여기서만 사용할 목적
	new MyInter1() {
		@Override
		public void prn() {
			System.out.println("익명클래스 구현 방법");
		}
	}.prn();
	
	new MyAbs1(){

		@Override
		void prn() {
			System.out.println("익명클래스 구현 법");
		}
	}.prn();
	
	
	}

}
