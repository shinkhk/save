package ch04;

public class Ex8 {

	public static void main(String[] args) {
		// 문제1. 1~30사이의 값중에 3의 배수의 합을 구하시오.
		int sum = 0;
		for (int i = 1; i < 31; i++) {
			if (i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println("sum : " + sum);
		// 문제2. 1~30사이의 값중에 짝수와 홀수의 합을 각각 구하시오.
		int sum1 = 0, sum2 = 0;
		for (int i = 1; i < 31; i++) {
			if(i%2==0) {
				//짝수
				sum1+=i;
			}else if(i%2!=0) {
				//홀수
				sum2+=i;
			}
		}
		System.out.println("짝수의 합 : " + sum1);
		System.out.println("홀수의 합 : " + sum2);
		
		/*
		 * 문제3. 1~50사이의 3,6,9의 합은? 
		 * Hint : %와 /를 사용. 33/10 => 3 
		 * sum : 627
		 */
		sum = 0;
		for (int i = 1; i < 51; i++) {
			int j = i%10;//1,~0, 1~0, 10,11,12
			int n = i/10;
			if(j==3||j==6||j==9) {
				System.out.print(i+"\t");
				sum+=i;
			}else if(n==3) {
				System.out.print(i+"\t");
				sum+=i;
			}
		}
		System.out.println("\nsum : " + sum);
		
	}
}







