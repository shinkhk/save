package ch04;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		//입력한 숫자가 양수인지 음수인지 0인지 판단하세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int a = sc.nextInt();
		
		if(a>0) {
			System.out.println("양수입니다.");
		}else if(a<0) {
			System.out.println("음수입니다.");
		}else if(a==0) {
			System.out.println("0 입니다.");
		}
		
	}

}







