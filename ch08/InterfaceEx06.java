package ch08;

// 다른 클래스 상속을 했다고 가정
public class InterfaceEx06 implements Runnable {

	String name;
	
	public InterfaceEx06(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i= 0; i<10; i++) {
			System.out.println(i+":"+name);
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
	

	
	public static void main(String[] args) {
		InterfaceEx06 a = new InterfaceEx06("첫번째");
		InterfaceEx06 b = new InterfaceEx06("두번째");
		new Thread(a).start();// 결론적으로 run 메소드 호출
		new Thread(b).start();
//		a.run();
//		b.run();
		
	}

}
