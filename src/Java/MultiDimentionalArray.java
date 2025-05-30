package Java;

public class MultiDimentionalArray {
	public static void main(String[] args) {

		int a[][] = new int [2][3];
		a[0][0]=2;
		a[0][1]=4;
		a[0][2]=5;
		
		a[1][0]=3;
		a[1][1]=4;
		a[1][2]=7;		
//		System.out.println(a[0][2]);
		
//		int b[][] = {{2,4,5},{3,4,7}};
//		System.out.println(b[0][1]);
			
//		2   4   5     0th row/index
//		3   4   7     1st row/index

		for (int i=0; i<2; i++)        //row
		{
			
			for (int j=0; j<3; j++)   //column
			{
				System.out.println(a[i][j]);
			}
		}
		
	}
}

