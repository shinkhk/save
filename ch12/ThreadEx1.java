package ch12;

public class ThreadEx1 extends Thread {
	
	String name;
	
	public ThreadEx1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(200);//0.2
				System.out.println(name + " : " + i);
			} catch (Exception e) {}
		}
	}
	
	public static void main(String[] args) {
		ThreadEx1 t1 = new ThreadEx1("첫번째");	
		ThreadEx1 t2 = new ThreadEx1("두번째");
		t1.start();//결과적으로 run 메서드 호출
		t2.start();
	}
}
