package ch06;

class SuperClass3{
	public SuperClass3() {
		super();
		System.out.println("Super 생성자");
	}
}

class SubClass3 extends SuperClass3{
	public SubClass3() {
		super();//생략:반드시 생성자의 첫번째 라인
		System.out.println("Sub 생성자");
	}
}

public class ConstructorEx3 {
	public static void main(String[] args) {
		SubClass3 s1 = new SubClass3();
	}

}
