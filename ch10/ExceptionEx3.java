package ch10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx3 {

	public static void main(String[] args) {
		Scanner s = null;
		try {
			int a, b;
			s = new Scanner(System.in);
			System.out.print("첫번째 숫자 : ");
			a = s.nextInt();
			System.out.print("두번째 숫자 : ");
			b = s.nextInt();
			System.out.println(a+"/"+b+"="+(a/b));
		//다중 catch일때는 하위 Exception이 위에 옴.
		//} catch (Exception  e) {
		} catch (ArithmeticException  e) {
			System.out.println("0으로 입력하면 안되요.");
		} catch (InputMismatchException  e) {
			System.out.println("숫자만 입력을 해야 합니다.");
		} finally {
			s.close();//사용후에 반드시 닫아야 한다.
		}
	}

}
