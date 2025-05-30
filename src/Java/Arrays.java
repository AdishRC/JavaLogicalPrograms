package Java;

public class Arrays {

	public static void main(String[] args) {

		int a[] = new int[5];
		a[0]= 24;
		a[1]= 78;
		a[2]= 100;
		a[3]= 998;
		a[4]= 8;

		System.out.println(a[2]);	
		for (int i=0; i<a.length; i++)
		{
			System.out.println(a[i]);
		}	
		
//		====================================================================================================================
				
		int b[] = {12, 102, 78, 56, 2};
		System.out.println(b[2]);
		
		int i=0;
		 while(i<a.length)
		 {
			 System.out.println(b[i]);
			 i++;
		 }
	}
}

