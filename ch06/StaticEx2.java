package ch06;

/*static 필드 및 메소드는 클래스명.필드 or 메소드 일때
 * 메모리 로딩이 되지만 non-static 필드 및 메소드는
 * 반드시 객체를 생성해야 메모리 로딩된다.
 * 그래서 non-static 필드 및 메소드는 static 필드 및 메소드에
 * 사용 할 수 없다.
 * */

public class StaticEx2 {

	static int a = 10;
	int b = 10;//non-static
	
	static void prn1() {
		System.out.println(a);
		//static 메소드에는 non-static 사용불가
		//System.out.println(b);
	}
	
	 void prn2() {
		System.out.println(a);
		System.out.println(b);
	}
	
	 public static void main(String[] args) {
		 StaticEx2 st = new StaticEx2();
		 st.prn1();
	}
}




