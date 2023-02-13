package ch11;

class Point2{
	int x, y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x +", " + y +")";
	}

}

public class ObjectEx2 {
	public static void main(String[] args) {
		Point2 p = new Point2(10, 20);
		System.out.println(p);
	}
}











