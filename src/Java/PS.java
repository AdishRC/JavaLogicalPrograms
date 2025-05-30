package Java;

public class PS {

//	   public static void main(String[] args) {
//		   
//	   }
	   
	public void doThis() {
		System.out.println("I am here");
	}

	@BeforeMethod
	public void beforeRun() {
		System.out.println("Run me first");
	}
	@AfterMethod
	public void afterRun() {
		System.out.println("Run me last");
	}
}
