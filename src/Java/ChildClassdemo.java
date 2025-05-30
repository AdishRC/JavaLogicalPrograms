package Java;

public class ChildClassdemo extends ParentClassdemo {

	//In this class child class access the child method as well as parent method using object of the child class (bcoz child class extends with parent class so child class access the both class method)
	//In this class parent class access only the parent method here not access the child method (bcoz child class extends with parent, so parent class access only parent method, bcoz parent class have not access method from child class)
	
	public static void main(String[] args) {
		ChildClassdemo cd = new ChildClassdemo();
		cd.newcolour();
		
		ParentClassdemo pd = new ParentClassdemo();
		pd.breaks();
	
	}

	public void engine()
	{
		System.out.println("new engine");
	}


	public void newcolour()
	{
		System.out.println(colours);
	}
}

