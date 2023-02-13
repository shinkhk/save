package ch09;
/* 내부(중첩)클래스
 * 1. 클래스 안에 선언 (활용도 높은)
 * 2. 클래스 안에 선언 이지만 static 클래스 선언 (활용x)
 * 3. 매소드 안에 클래스 선언 (활용도 낮음)
 * 4. 매소드 안에 선언을 하고 동시 생성 익명클래스(활용도 높음)
 */

interface MyInter{
	void prn();
}

public class InnerEx01 {

class Outer1{
	class Inner1{
		
	}
	

	
//	매소드 안에 매소드는 선언 불가
	void prn() {
		class Inner3{
			
		}
		
		new MyInter() {	
			@Override
			public void prn() {
			}
		};
	}
	
}


	
	public static void main(String[] args) {

	}
	
}
