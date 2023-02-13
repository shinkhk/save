package ch04;

public class Ex9 {

	public static void main(String[] args) {
		//while문을 이용해서 1~10까지의 합을 구하시오.
		int sum = 0;
		int i = 1;
		while(i<11) {
			sum+=i;
			i++;
		}
		System.out.println("sum : " + sum);
		
		while(true) {
			System.out.println("while문 실행");
			if(true) {
				break;//자기를 감싸고 있는 반복문 빠져 나감.
			}
		}//--while
		
		do {
			System.out.println("무조건 한번은 실행");
		} while (true);
	}
}












