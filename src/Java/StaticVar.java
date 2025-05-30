package Java;

public class StaticVar {
	String name;     //Instance Variable
	String address;
	static String city = "Banglore";    //Class Variables
	static int i=0;  //sharing it happens in every object, if you remove static then newly same value updated in every object

	public StaticVar(String name, String address)
	{
		this.name=name;    //Local Variables
		this.address=address;
		i++;
		System.out.println(i);
	}
	
	public void getAddress()
	{
		System.out.println(address+" "+city);
	}
	
	public static void getCity()    //Static method will accept only static variable
	{
		System.out.println(city);
	}
	
	public static void main(String[] args) {
		StaticVar obj = new StaticVar("Bob", "Saphale");
		StaticVar obj1 = new StaticVar("Ram", "Palghar");
		StaticVar obj2 = new StaticVar("Sita", "Boisar");
		obj.getAddress();
		obj1.getAddress();
		StaticVar.getCity();    //All static methods are call with using only class name, and not an class object
	}
}

