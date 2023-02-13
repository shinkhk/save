package ch12;

public class RunnableEx1 implements Runnable {
	
	String name;
	
	public RunnableEx1(String name) {
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
		RunnableEx1 r1 = new RunnableEx1("하나");
		RunnableEx1 r2 = new RunnableEx1("둘");
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();//JVM안에 있는 Thread 스케줄러 등록
		t2.start();
	}
}







