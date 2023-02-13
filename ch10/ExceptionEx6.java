package ch10;

public class ExceptionEx6 {
	public static void main(String[] args) {
		try {
			exce3();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void exce1() throws Exception{
		
	}
	
	public static void exce2() throws Exception{
		exce1();
	}
	public static void exce3() throws Exception{
		exce2();
	}
}
