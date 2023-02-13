package ch11;

import java.lang.*;//생략

class Point{}

public class ObjectEx1 {
	public static void main(String[] args) {
		Point p = new Point();
		System.out.println("클래스이름 : " + p.getClass());
		System.out.println("해쉬코드 : " + p.hashCode());
		//toString 생략가능
		System.out.println("객체문자열 : " + p.toString());
		Point p1 = new Point();
		System.out.println("클래스이름 : " + p1.getClass());
		System.out.println("해쉬코드 : " + p1.hashCode());
		System.out.println("객체문자열 : " + p1.toString());
		String s = new String("금요일");
		System.out.println("객체문자열 : " + s.toString());
		
		
		
		
	}
}
