package javabasics;
import java.util.Scanner;
public class make_triangle {
	public static void main(String args[]) {
		int n=new Scanner(System.in).nextInt();
		for(int i=0;i<n;i++)
		{
			for(int j=n-i;j>0;j--) System.out.printf(" ");
			for(int k=1;k<=1+2*i;k++) System.out.printf("*");
			System.out.printf("\n");
		}
		
	}
}
