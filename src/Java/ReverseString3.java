package Java;

public class ReverseString3 {

	public static void main(String[] args) {

		//1) Using + (string concatenation) operator

		String str = "ABCD";
		String rev ="";
		int len = str.length();

		for(int i=len-1; i>=0; i--) {
			rev= rev+str.charAt(i);
		}
		System.out.println("Reverse String is " + rev);
		
		
		//2)  Using character array

		//		char a[]=str.toCharArray();
		//		int len=a.length;    //4
		//		
		//		for(int i=len-1; i>=0; i--)     //3 2 1 0 -1
		//		{
		//			rev=rev+a[i];        //DCBA
		//		}
		//		System.out.println("Reverse string is:"+ rev);


		//3) Using String Buffer class

		//		StringBuffer sb = new StringBuffer(str);
		//		System.out.println(sb.reverse());
	}
}

