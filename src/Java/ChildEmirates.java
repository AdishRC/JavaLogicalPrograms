package Java;

public class ChildEmirates extends ParentAirCraft {

	public static void main(String[] args) {

		ChildEmirates ce = new ChildEmirates();
		ce.bodyColor();
		ce.engine();
		ce.safetyGuidelines();
		ce.addition();
	}

	@Override
	public void bodyColor() {
		System.out.println("Red color on the body");

	}

	@Override
	public void addition() {
		int a=3;
		System.out.println(a);

	}
}

