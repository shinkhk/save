package ch12;

public  class SynchornizedEx1 
implements Runnable{

	public void a(String who) {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			System.out.println(who + "b() 호출");
			b(who);
		}
	}
	
	public synchronized void b(String who) {
		try {
			Thread.sleep(200);
		} catch (Exception e) {
			System.out.println(who + "a() 호출");
			a(who);
		}
	}
	
	
	
	
		@Override
	public synchronized void run() {
			b(Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		SynchornizedEx1 sch = new SynchornizedEx1();
		Thread t1 = new Thread(sch, "first");
		Thread t2 = new Thread(sch, "second");
		t1.start();
		t2.start();
	}


}
