package Java;

import java.util.Scanner;

public class LargestOf3Numbers9 {

	public static void main(String[] args) {

//		int a = 54768646;
//		int b = 767686;
//		int c = 65758;
//		
//		if(a>b && a>c)
//		{
//			System.out.println(a + " A is largest");
//		}
//		
//		 else if(b>c && b>a)
//		{
//			System.out.println(b + " B is largest");
//		}
//		
//		 else
//		 {
//			 System.out.println(c + " C is the largest number");
//		 }
		
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter First Number:");
		int a=sc.nextInt();

		System.out.println("Enter Second Number:");
		int b=sc.nextInt();

		System.out.println("Enter Third Number:");
		int c=sc.nextInt();

		//Approach1 - Logic

				if(a>b && a>c)
				{
					System.out.println(a+ " is largest number");
				}
				else if(b>a && b>c)
				{
					System.out.println(b+ " is largest number");
				}
				else
				{
					System.out.println(c+ " is largest number");
				}

		//Ternary Operator

		int largest1 = a>b?a:b;     //largest of a & b
		int largest2 = c>largest1?c:largest1;   //largest of c & largest1
		System.out.println(largest2+" is largest number");
	}
}

