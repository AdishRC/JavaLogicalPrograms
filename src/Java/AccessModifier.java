package Java;

public class AccessModifier {

	public static void main(String[] args) {

	}

	public void ABC()
	{
		//public:- variables, methods you will have to access across all the packages (whole project)
	}

	void XYZ()
	{
		//default:- variables, methods you will have to access only the package level
	}

	private void Apple()
	{
		//private:- you can not access methods or variables out side the class, you can access only within the same class
	}

	protected void Cherry()
	{

		//protected:- variable/methods as private : you can access those in sub classes only (other packages)..
		//protected:- variable/methods you can access in the package level + also you can access if you have extends your child class with parent class
	}
}

