package Java;

public class MethodOverriding {

	//In class with same method name, but different data type, different argument type and count of argument different
	public static void main(String[] args) {
		MethodOverriding mo = new MethodOverriding();
		mo.getData(12);
		mo.getData("Adish");
		mo.getData(8, 4);
	}

	public void getData(int a)
	{
		System.out.println(a);
	}
	
	public void getData(int a, int b)
	{
		System.out.println(a);
		System.out.println(b);
	}
	
	public void getData(String abc)
	{
		System.out.println(abc);
	}
}

