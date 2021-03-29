package exercise22_03;

import java.util.*;
public class Exercise22_03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string s1: ");
		String s1 = RanString.ranstring2()+RanString.ranstring();
		System.out.print("Enter a string s2: ");
		String s2 = RanString.ranstring();
		int foundAt = -1;
		long startTime = System.currentTimeMillis(); 
		if (s1.length() >= s2.length()) {
			for (int i = 0; i < s1.length()-s2.length()+1; i++) {
				if (s1.charAt(i) == s2.charAt(0)) {
					Boolean matching = true;
					for (int j = 0; j < s2.length(); j++) {
						if (!(s1.charAt(i+j) == s2.charAt(j))) {
							matching = false;
							break;
						}
					}

					if (matching) {
						foundAt = i;
						break;
					}
				}
			}
			System.out.println("Matched at index " + foundAt);
			long time = System.currentTimeMillis() - startTime; 
			System.out.print("Time taken: " + time);
		}
		else System.out.print("A string cannot be contained in a string shorter than itself.");
	}
}

class RanString {
	public static String ranstring() {
		String hold = "";
		for (int i = 0; i < 49999; i++) hold += "a";
		hold += "b";
		
		return hold;
	}
	public static String ranstring2() {
		String hold = "";
		for (int i = 0; i < 5000; i++)
			hold += "aaaaaaaaaa";
		
		return hold;
	}
	
}