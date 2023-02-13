package ch13;

import java.util.Vector;

public class VectorEx1 {

	public static void main(String[] args) {
		Vector vlist = new Vector();
		System.out.println(vlist.size());
		System.out.println(vlist.capacity());
		System.out.println("----------------");
		vlist.add(new String("하하"));
		vlist.add("하하");
		vlist.add(Integer.valueOf(22));
		vlist.add(23);
		System.out.println(vlist.size());
		//배열과 Vector 밑에는 항상 for
		for (int i = 0; i < vlist.size(); i++) {
			System.out.println(vlist.get(i));
		}
		System.out.println("---------------");
		for (Object obj : vlist) {
			System.out.println(obj);
		}
	}

}





