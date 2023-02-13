package ch04;

import java.util.Scanner;

public class Ex1 {
	
	public static void main(String[] args) {
		/*
		 * 제어문 : 조건(선택)문, 반복문
		 *  - 조건문 : if-else, switch
		 *  - 반복문 : for, while
		 * */
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int a = sc.nextInt();
		System.out.println("입력한 숫자 : " + a);
		
		if(a%3==0) {
			System.out.println("3의 배수입니다.");
		}else {
			System.out.println("3의 배수가 아닙니다.");
		}
		
	}

}









