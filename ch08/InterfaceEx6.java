package ch08;

import ch06.ThisEx1;

//다른 클래스 상속을 했다고 가정하고....
public class InterfaceEx6 implements Runnable{

	String name;
	
	public InterfaceEx6(String name) {
		this.name = name;	
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + name);
			try {
				Thread.sleep(500);
			} catch (Exception e) {}
		}
	}
	
	public static void main(String[] args) {
			InterfaceEx6 a = new InterfaceEx6("첫번째");
			InterfaceEx6 b = new InterfaceEx6("두번째");
			new Thread(a).start();//결론적으로 run메서드 호출
			new Thread(b).start();
	}
}
