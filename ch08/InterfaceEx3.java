package ch08;

interface InterfaceA3{
	void prn1();
}
interface InterfaceB3{
	void prn2();
}

class MyClass implements InterfaceA3, InterfaceB3{
	@Override
	public void prn1() {
	}
	@Override
	public void prn2() {
	}
}

public class InterfaceEx3 {

}
