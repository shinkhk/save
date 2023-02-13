package ch04;

import java.util.Scanner;

public class Ex6 {
	
	public static void main(String[] args) {
		/*
		 * 점수와 학년을 입력을 받아서 60이상이면 합격인데, 
		 * 4학년은 70점 이상 합격이다.
		 */
		Scanner sc = new Scanner(System.in);
		int score, year;
		System.out.print("점수를 입력하세요.(0~100): ");
		score = sc.nextInt();
		System.out.print("학년을 입력하세요.(1~4): ");
		year = sc.nextInt();
		
		//힌트 : 중첩 if문 사용
		if(score>=60) {
			if(year!=4) {
				//60점 이상이고 1~3학년
				System.out.println("합격");
			}else if(score>=70) {
				//점수가 70점 이상
				System.out.println("합격");
			} else {
				//70점 미만의 4학년인 경우
				System.out.println("불합격");
			}
		}else {
			System.out.println("불합격");
		}
	}

}











