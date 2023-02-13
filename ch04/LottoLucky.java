package ch04;

import java.util.Arrays;

public class LottoLucky {

	public static void main(String[] args) {
		int lotto[] = getLotto();
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + "\t");
		}
	}
	
	public static int[] getLotto() {
		int lotto[] = new int[6];
		//배열 밑에 항상 for문 있다.
		//중복로직 추가
		boolean isNumThere = false;
		for (int i = 0; i < lotto.length; i++) {
			isNumThere = false;
			lotto[i] = (int)(Math.random()*45)+1;
			for (int j = 0; j < i; j++) {
				if(lotto[i]==lotto[j]) {
					isNumThere = true;
				}
			}
			if(isNumThere)
				i--;
		}
		Arrays.sort(lotto);//올럼차순 정렬
		return lotto;
	}

}









