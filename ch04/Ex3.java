package ch04;

import java.util.Scanner;

public class Ex3 {
	
	public static void main(String[] args) {
		//입력한 1~20사이의 숫자중에 3, 6, 9인지를 판단하세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요.");
		int a = sc.nextInt();
		//1,2,3,4,5,6,7,8,9,10,11,12,13~20
		int b = a%10;//십자리 날라가고 일자리만 리턴
		//if(b==3||b==6||b==9) {
		if(b!=0&&b%3==0) {
			System.out.println("짝");
		}else {
			System.out.println(a);
		}
	}
}









