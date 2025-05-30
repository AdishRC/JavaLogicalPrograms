package Java;

public class ExceptionDemo {

	public static void main(String[] args) throws IndexOutOfBoundsException {
		int b=8;
		int c=0;

		try 
		{
			int k=b/c;
			System.out.println(k);
			
//			int a[] = new int[5];
//			System.out.println(a[8]);
		}

		catch(ArithmeticException ae)
		{
			System.out.println("I catched the Arithmetic Exception");
		}

		catch(Exception e)
		{
			System.out.println("I catched the Error Exception");
		}
		
		finally
		{
			//If your test are passed try and finally both block are executed successfully, but if failed proper exception are show
			System.out.println("Executed Succesfully!!!");
		}
	}
}

