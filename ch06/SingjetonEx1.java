package ch06;

class Singjeton1{
	
	private static Singjeton1 instance = null;
	
	private Singjeton1() {}
	
	public static Singjeton1 getInstanc() {
		if(instance == null)
			instance = new Singjeton1();
		return instance;
		}
	}


public class SingjetonEx1 {

	public static void main(String[] args) {

	}

}
