package ch07;

abstract class Shape{
	int x,y;
	void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	abstract void draw();
}

class Triange extends Shape{
	@Override
	void draw() {
		System.out.println("삼각형그리기");
	}
}

class Rectangle extends Shape{
	@Override
	void draw() {
		System.out.println("사각형그리기");
	}
}

class Cirde extends Shape{
	@Override
	void draw() {
		System.out.println("원그리기");
	}
}

public class AbstractEx04 {

	public static void main(String[] args) {
		
	}

}
