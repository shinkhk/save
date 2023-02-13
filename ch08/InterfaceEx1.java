package ch08;

interface Calc{
	void plus(int a, int b);//자동 추상메서드
}

class Function /* extends Object */ implements Calc{
	@Override
	public void plus(int a, int b) {
	}
}

class Graphics implements Calc{
	@Override
	public void plus(int a, int b) {
	}
}

public class InterfaceEx1 {

	public static void main(String[] args) {

	}

}
