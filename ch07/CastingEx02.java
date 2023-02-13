//package ch07;
//
//import java.util.Vector;
//
//class Persom2{
//	String name;
//	public Persom2(String name) {
//		this.name = name;
//	}
//}
//class Student2 extends Persom2{
//	String grade;
//	public Student2(String nama) {
//		
//	
//	}
//}
//
//public class CastingEx02 {
//
//	public static void main(String[] args) {
//		Persom2 p;
//		Student2 s = new Student2("홍길동");
//		p = s; // 업캐스팅
//		System.out.println(p.name);
////		System.out.println(p.grade);//받아올수 없음
//		
//		Student2 s2;
//		Persom2 p2 = new Persom2("홍길투");
////		s2 = (Student2)p2;// 다운캐스팅 실행하면 오류남
//		
//		Vector v = new Vector();
//		String str = new String();
//		Student2 s3 = new Student2("홍길삼");
//		v.add(str);
//		v.add(s3);
//		String str1 = (String)v.get(0);
//		String s4 = (String)v.get(0);
//		
//		
//}
//}