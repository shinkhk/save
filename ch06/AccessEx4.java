package ch06;

import ch06_1.Access3;

class Access4 extends Access3{
	public Access4() {
		//상속에서 public, protected까지 유산
		//private 제외
		int k = b + c;
	}
}

public class AccessEx4 {
	public static void main(String[] args) {
		
		Access3 ac = new Access3();
		
		
	}
}
