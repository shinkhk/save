package ch14;

import java.io.FileReader;

public class FileReaderEx1 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("ch14/aaa.txt");
			int a;
			while((a=fr.read())!=-1) {
				System.out.print((char)a);
			}
			fr.close();
			System.out.println("End~~");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
