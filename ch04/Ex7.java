package ch04;

public class Ex7 {
	
	int b;

	public static void main(String[] args) {
		//for문을 이용해서 1~10까지의 합을 구하시오.
		int total = 0;
		for(int i=1, j=0;i<11;i++,j++) {
			total = total + i;
		}
		System.out.println("total : " + total);
		int j = 0;
		for (;j<11;j++) {
			System.out.println("j : " + j);
		}
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			System.out.println(i);
		}
		for (;;) {
			System.out.println("무한반복");
		}
//		System.out.println("끝");
	}
}





