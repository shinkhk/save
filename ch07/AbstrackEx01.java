package ch07;

import java.awt.Component;

// 추상클래스
abstract class Abtrack1{
	//추상메소드
	abstract void prn();
}

class Nomail extends Abtrack1{
	@Override
	void prn() {
	} 
}

class MComponent extends Component{
	
}

public class AbstrackEx01 {

	public static void main(String[] args) {
		Abtrack1 a;
//		a = new Abtrack1(); 객체생성불가
		a = new Nomail();
	}

}
