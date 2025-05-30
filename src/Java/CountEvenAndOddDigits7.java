package Java;

import java.util.Scanner;

public class CountEvenAndOddDigits7 {

	public static void main(String[] args) {

		int num = 1234;
		int even_count = 0;
		int odd_count = 0;

		while(num>0)    //1234    123    12   1
		{
			int rem = num%10;   //4   3   2   1                 Extract the number (last number) using modular division     %
			num = num/10;   //123     12   1   0                Eliminate the the last digit (last number) using division   /
			
			if(rem%2==0)
			{
				even_count++;     //1   2
			}
			else
			{
				odd_count++;     //1    2
			}
		}

		System.out.println("Number of Even Numbers:"+even_count);
		System.out.println("Number of odd Numbers:"+odd_count);		

//		Scanner sc = new Scanner (System.in);
//		System.out.println("Enter The Number");
//		int num = sc.nextInt();
//
//		int even=0;
//		int odd=0;
//
//		while(num>0)
//		{
//			int rem= num%10;
//			num= num/10;
//
//			if(rem%2==0)
//			{
//				even++;
//			}
//
//			else
//			{
//				odd++;
//			}
//		}
//		
//		System.out.println("Number of Even Numbers:"+even);
//		System.out.println("Number of odd Numbers:"+odd);
	}
}

