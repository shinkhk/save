package ch10;

public class ExceptionEx2 {
	public static void main(String[] args) {
		try {
			int arr[] = new int[3];
			arr[0] = 10;
			arr[1] = 10;
			arr[2] = 10;
			arr[3] = 10;
			System.out.println("실행 되나요?");
		} catch (Exception e) {
			System.out.println("배열 예외입니다.");
		} finally {//예외에 관계없이 무조건 실행
			System.out.println("finally~");
		}
	}
}
