package ch06;

class This1{
	public This1(This2 t2) {
	
	}
}

class This2{
	public This2() {
		This1 t1 = new This1(this);
	}
}

public class ThisEx1 {
	public static void main(String[] args) {
		This2 t2 = new This2();
	}
}
