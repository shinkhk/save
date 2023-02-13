package ch07;

import java.util.Iterator;

class Animal{
	void move() {
		System.out.println("움직여");
	}
}

class Bird extends Animal{
	String name = "새";
	@Override
	void move() {
		System.out.println(name + "날아라");
	}
}

class Fish extends Animal{
	String name = "물고기";
	@Override
	void move() {
		System.out.println(name + "헤엄처라");
	}
}

class cheetah extends Animal{
	String name = "치타";
	@Override
	void move() {
		System.out.println(name + "달려라");
	}
}

public class CastingEx03 {

	public static void main(String[] args) {
		Animal ani[] = new Animal[3];			//Animal 타입의 객체를 저장할수있는 칸 3개를 만듬
		ani[0] = new Bird();
		ani[1] = new Fish();
		ani[2] = new cheetah();
		
		for(int i = 0; i<ani.length; i++) {
			ani[i].move(); // 동적 바인딩 - 하위객채가 상위객체의 메소드를 덮에버림 즉 하위객체의 메소드가 호출됨
		}
	}

}
