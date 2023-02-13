package ch04;

public class Ex10 {

	public static void main(String[] args) {
		//break는 반목문에서는 중간에 종료되는 기능
		int a = 0;
		while(true) {
			if(a==10) {
				break;
			}
			System.out.println("a : " + a);
			a++;
		}//--while
		
		/*for문을 이용하여 순차적으로 1에서 n까지의 
		합이 100에서 최대한 가까운 합을 리턴*/
		int sum = 0;
		for (int i = 0; true; i++) {
			if(sum>100) {
				break;
			}
			System.out.print(i+"\t");
			sum+=i;
		}
		System.out.println("sum : " + sum);
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.println(i + " + " + j + " = " + (i+j));
			}//--for2
			System.out.println();
		}//--for1
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				if(i+j>10) {
					break; //for2를 빠져 나온다.
				}
			}//--for2
		}//--for1
		
		iot ://라벨값 : 구역의 시작 위치
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 10; j++) {
				if(i+j>10) {
					break iot; 
				}
			}//--for2
		}//--for1	
		
		//문제: 중첩 for문을 이용해서 i와j의 합이 30이 넘어면 빠져나오시오.
		iot2 : 
		for (int i = 0; true; i++) {
			for (int j = 0; true; j++) {
				System.out.println(i+j);
				if(i+j>30) {
					break iot2;
				}
			}
		}
		
	}

	
	
}











