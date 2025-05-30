package Java;

public class AustralianTraffic implements CentralTraffic, ContinetalTraffic{

	public static void main(String[] args) {
		//Interface is same as a class only difference between creating a method without body
		CentralTraffic a = new AustralianTraffic();
		a.greenGo();
		a.FlashYellow();
		a.redStop();
//		a.Walk();
		
		AustralianTraffic at = new AustralianTraffic();
		at.Walk();
		
		ContinetalTraffic ct = new AustralianTraffic();
		ct.Train();
		
	}

	@Override
	public void greenGo() {
		System.out.println("greengo implementation");
	}

	@Override
	public void redStop() {
		System.out.println("redstop implementation");
	}

	@Override
	public void FlashYellow() {
		System.out.println("flasyellow implementation");
	}
	
	public void Walk()
	{
	System.out.println("walking");
	}

	@Override
	public void Train() {
		System.out.println("Vande Bharat");
	}
}

