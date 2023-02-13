package ch11;

import java.util.Vector;

public class WrapperEx1 {

	public static void main(String[] args) {
		//자바의 기본형 Data Type (8가지 -> 객체화)
		int a = 10;
		//Auto Boxing
		Integer it1 = a;//원래 변함 안됨.
		//Auto unBoxing;
		int b = it1;
		Vector v = new Vector();
		v.add(a);//Auto Boxing
		v.add(it1);
		int c = (Integer)v.get(0);//Auto unBoxing;
		
		Integer it2 = new Integer(10);
		Integer it3 = new Integer("20");
		Integer it4 = Integer.valueOf(10);
		Integer it5 = Integer.valueOf("20");
		int a1 = it4.intValue();
		a1 = it4;
		int b1 = it5.intValue();
		int c1 = a1 + b1;
		System.out.println(c1);
		int a2 = Integer.parseInt("30");
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.toBinaryString(a2));
	}
}








