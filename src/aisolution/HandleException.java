package aisolution;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface HandleException {
	static final Scanner sc = new Scanner(System.in);

	public static int inputAge(String s) {	
		while(true) {
			int temp = 0;
			try {
				System.out.print(s);
				sc.nextInt();
				if(!((temp >= 0) && (temp <= 100))) {
					System.out.println();
					System.out.println("Invalid Input. Please try again.");
					System.out.println();
					continue;
				}
				return temp;
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println();
				System.out.println("Invalid Input. Please try again.");
				System.out.println();
			}
		}
	}
	
}
