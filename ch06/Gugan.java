package ch06;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gugan {

	public static void main(String[] args) {
		try {
		BufferedReader bufferedReader = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer stringTokenizer= new StringTokenizer(bufferedReader.readLine());
		int suNo = Integer.parseInt( stringTokenizer.nextToken());
		int quizNo = Integer.parseInt(stringTokenizer.nextToken());
		
		long[] S =new long[suNo];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for(int i=1;i<=suNo;i++) {
			S[i]=S[i]+Integer.parseInt(stringTokenizer.nextToken());
			
		}
		for(int q=0;q<quizNo;q++) {
			stringTokenizer =new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			System.out.print(S[j]-S[i-1]);
			
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}