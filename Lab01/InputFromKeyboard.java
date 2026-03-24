package javabasics;
import java.util.Scanner;
public class InputFromKeyboard {
	public static void main(String args[]) {
		Scanner keyboard=new Scanner(System.in);
		System.out.println("Vui long nhap ten:");
		String ten=keyboard.nextLine();
		System.out.println("Vui long nhap tuoi:");
		int tuoi=keyboard.nextInt();
		System.out.println("Vui long nhap chieu cao:");
		double height=keyboard.nextDouble();
		System.out.println("Mr/Mrs "+ten+ " "+tuoi+" years old "+ "cao "+height);
		
	}

}
