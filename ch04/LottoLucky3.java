package ch04;

import java.util.Arrays;

public class LottoLucky3 {
	
	public static void main(String[] args) {
		
		int arr[] = new int[6];
		for (int i = 0; i < arr.length; i++) {
			int lucky = (int)(Math.random()*45+1);
			if(isDuplication(arr, lucky)) {
				i--;
			}else {
				arr[i] = lucky;
			}
		}
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	//"12 34 2 45".contains("2") 
	//중복이면 true
	public static boolean isDuplication(int arr[],int lucky) {
		String chk = "";
		for (int i = 0; i < arr.length; i++) {
			chk+=arr[i]+" ";
		}
		return chk.contains(String.valueOf(lucky));
	}

}
