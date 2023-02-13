package ch11;

import java.util.Arrays;

public class PalindromeEx1 {

	static final int MAX = 100000;

	public static void main(String[] args) {
		/*
		 * 앞에서부터 읽을 때나 뒤에서부터 읽을 때나 모양이 같은 수를 대칭수(palindrome)라고 합니다. 대칭수(palindrome)인
		 * 585는 2진수로 나타내도 1001001001가 되어 여전히 대칭수입니다.
		 */

		// 문제1.10진법의 대칭수인 100,000 이하 숫자의 합은 얼마입니까?

		// 문제2.2진법의 대칭수인 100,000 이하 숫자의 합은 얼마입니까?

		// 문제3.10진법과 2진법으로 모두 대칭수인 100,000 이하 숫자의 합은 얼마입니까?
		
		int[] answer = new int[3];
		PalindromeEx1 pe = new PalindromeEx1();
		for (int i = 1; i <= MAX; i++) {
			if (pe.isPalindrome(i, 10)) {
				answer[0] += i;
			}
			if (pe.isPalindrome(i, 2)) {
				answer[1] += i;
			}
			if (pe.isPalindrome(i, 2) && pe.isPalindrome(i, 10)) {
				answer[2] += i;
			}
		}
		System.out.println(Arrays.toString(answer));
	}

	public boolean isPalindrome(int x, int numberType) {
		StringBuilder sb = new StringBuilder(Integer.toString(x, numberType));
		if (sb.toString().equals(sb.reverse().toString())) {
			return true;
		}
		else
			return false;
	}
}