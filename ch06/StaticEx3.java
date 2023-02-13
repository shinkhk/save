package ch06;

import common.util.StringUtil;

class Static3{
	
	/*static 필드는 동일한 클래스의 모든 객체가 공유의 목적으로 
	 * 하나만 메모리에 만들어 진다.*/
	static int a;
	int b;
	
}

public class StaticEx3 {
	public static void main(String[] args) {
		Static3 st1 = new Static3();
		Static3 st2 = new Static3();
		st1.b = 10;
		st2.b = 20;
		System.out.println(st1.b);
		System.out.println(st2.b);
		///////////////////////
		st1.a = 10;
		st2.a = 20;
		System.out.println(st1.a);
		System.out.println(st2.a);
		
		String str = "10000000000000000";
		System.out.println(StringUtil.addComma(str));
	}
}






