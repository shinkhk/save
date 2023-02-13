package ch14;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ReaderEx1 {
	public static void main(String[] args) {
		InputStream is = System.in;
		//1byte단위로 들어온 data를 문자단위로 변환
		Reader reader = new  InputStreamReader(is);
		while(true) {
			try {
				int a = reader.read();//내부적인 쓰레드 : 입력 전에 대기
				if(a==-1/*ctrl+z*/) break;
				System.out.print((char)a);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}
}







