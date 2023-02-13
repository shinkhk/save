package ch13;

class Box1{//다양한 타입의 데이터를 저장
	
	private Object data;
	
	public void set(Object data) {
		this.data = data;
	}
	
	public Object get() {
		return data;
	}
}

class Box2<T>{
	 private T data;
	 public void set(T data) {
		 this.data = data;
	 }
	 public T get() {
		 return data;
	 }
}

public class GenericEx1 {
	public static void main(String[] args) {
		Box1 b = new Box1();
		b.set(Integer.valueOf(22));
		Integer i = (Integer)b.get();
		b.set("하하");
		//Integer i2 = (Integer)b.get();
		Box2<String> b2 = new Box2<String>();
		b2.set("하하");
		//b2.set(Integer.valueOf(23));
	}
}







