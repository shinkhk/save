package ch07;


class Car1 {
	int velocity;
	
	void speedUp() {
		velocity+=5;
	}
	
	void speedDown() {
		velocity--;
		if(velocity < 0)
			velocity = 0;
	}	
}

class Taxi1 extends Car1{
	@Override // Annotation (java5.5부터 추가된 문법)
	void speedUp() {
		super.speedUp();
	}
	
}

class Bus1 extends Car1{
	@Override // Annotation (java5.5부터 추가된 문법)
	void speedUp() {
			super.speedUp();
			if(velocity > 100)
				velocity = 100;
		}
	}
	

public class Ex1 {

	public static void main(String[] args) {
		Taxi1 t = new Taxi1();
		t.speedUp();
		System.out.println(t.velocity);
		
		Bus1 b = new Bus1();
		b.velocity = 110;
		b.speedUp();
		System.out.println(b.velocity);
	}

}
