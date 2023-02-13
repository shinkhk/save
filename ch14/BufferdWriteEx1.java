package ch14;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class BufferdWriteEx1 {

	public static void main(String[] args) {
		String str = "오늘은 정말 즐거운 금요일 입니다";
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			bw.write(str,0,str.length());
			bw.newLine();
			bw.write(str);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
