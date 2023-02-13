package ch06;

class Singleton1{
	
	private static Singleton1 instance = null;
	
	private Singleton1() {}
	
	public static Singleton1 getInstace() {
		if(instance==null)
			instance = new Singleton1();
		return instance;
	}
	
}

public class SingletonEx1 {
	public static void main(String[] args) {
		
	}
}
