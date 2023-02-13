package ch08;

abstract class Tv{
	String color;
	boolean power;
	int ch;
	void powerOnOff() {
		power=!power;
	}
	void upCh() {
		ch++;
	}
	void downCh() {
		ch--;
	}
	abstract void setModel();
}

class SMTv extends Tv implements RemoteControl{
	@Override
	void setModel() {}
	@Override
	public void turnOff() {
	}
	@Override
	public void turnOn() {
	}
}

class LGTv extends Tv implements RemoteControl{
	@Override
	void setModel() {}

	@Override
	public void turnOn() {
	}

	@Override
	public void turnOff() {
	}
}

interface RemoteControl{
	void turnOn();
	void turnOff();
}

public class InterfaceEx4 {

}





