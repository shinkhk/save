package ch06;


class Constructor5{
	
	int a;
	String str;
	
	public Constructor5() {
		/*
		 * 중복된 기능
		 * */
	}
	
	public Constructor5(int i) {
		a = i;
		/*
		 * 중복된 기능
		 * */
	}
	
	public Constructor5(String s) {
		str = s;
		/*
		 * 중복된 기능
		 * */
	}
}

class Constructor5_1{
	int a;
	String str;
	public Constructor5_1() {
		super();
		/*
		 * 중복된 기능*/
	}
	public Constructor5_1(int i) {
		//자신의 디폴트 생성자 호출. 반드시 생성자에 첫번째 라인
		//즉.super() 같이 사용 불가
		this();
		a = i;
	}
	public Constructor5_1(String s) {
		this();
		str = s;
	}
}

public class ConstructorEx5 {
	public static void main(String[] args) {

	}
}
