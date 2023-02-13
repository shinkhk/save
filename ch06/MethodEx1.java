package ch06;


class Method1{
	
	int abs(int num) {
		if(num<0)
			num=-num;
		return num;
	}
	
	void prn(int a, int b) {
		int c = a + b;
		System.out.println(a + " + " + b + " = " + c);
	}
	
}

public class MethodEx1 {
	public static void main(String[] args) {
		Method1 m = new Method1();
		//return형이 있는 메서드이라도 값을 반드시 받을 필요는 없다
		int a = m.abs(-10);
		System.out.println(a);
		m.prn(10, 20);
		
	}
}






