package ch06;

//java.awt.Frame에 paramString의 결과값을 출력하시오.

import java.awt.Frame;

public class AccessEx5 extends Frame{
	public AccessEx5() {
		System.out.println(paramString());
	}
	
	public static void main(String[] args) {
		AccessEx5 ac = new AccessEx5();
	}
}