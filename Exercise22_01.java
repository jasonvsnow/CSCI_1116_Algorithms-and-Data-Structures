package exercise22_01;

import java.util.*;

/*
 * Author: Jason Snow
 * Date: 03/29/21 
 * 
 * This program finds the maximum consecutive increasingly ordered substring from a string entered by the user and displays it.
 */
public class Exercise22_01 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a string: ");
		String string = input.nextLine();
		String currentMax = "";
		String compare = "";

		for (int i = 0; i < string.length(); i++) {
			if (compare.length() == 0) {
				compare += string.charAt(i);
			}
			else {
				char current = string.charAt(i);
				if (current > compare.charAt(compare.length()-1)) compare += current;
				else {
					if (compare.length() > currentMax.length()) currentMax = compare;
					compare = "";
					compare += current;
				}		 
			}	
		}
		if (compare.length() > currentMax.length()) currentMax = compare;
		System.out.print("Maximum consecutive substring is " + currentMax);
	 	
		
		
		
		
	}
}

