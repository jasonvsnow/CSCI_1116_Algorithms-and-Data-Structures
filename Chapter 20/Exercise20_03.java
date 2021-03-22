package chapter20;

import java.util.*;


/*
 * Author: Jason Snow
 * Date: 03/22/2021
 * 
 * This program stores States and Capitals in a random order to be displayed in that random order to the user, who wil be given a state and guess the capital.
 */
public class Exercise20_03 {
	public static void main(String[] args) {
		
		
		String[][] stateCapital = {
				{"Alabama", "Montgomery"},
				{"Alaska", "Juneau"},
				{"Arizona", "Phoenix"},
				{"Arkansas", "Little Rock"},
				{"California", "Sacramento"},
				{"Colorado", "Denver"},
				{"Connecticut", "Hartford"},
				{"Delaware", "Dover"},
				{"Florida", "Tallahassee"},
				{"Georgia", "Atlanta"},
				{"Hawaii", "Honolulu"},
				{"Idaho", "Boise"},
				{"Illinois", "Springfield"},
				{"Indiana", "Indianapolis"},
				{"Iowa", "Des Moines"},
				{"Kansas", "Topeka"},
				{"Kentucky", "Frankfort"},
				{"Louisiana", "Baton Rouge"},
				{"Maine", "Augusta"},
				{"Maryland", "Annapolis"},
				{"Massachusettes", "Boston"},
				{"Michigan", "Lansing"},
				{"Minnesota", "Saint Paul"},
				{"Mississippi", "Jackson"},
				{"Missouri", "Jefferson City"},
				{"Montana", "Helena"},
				{"Nebraska", "Lincoln"},
				{"Nevada", "Carson City"},
				{"New Hampshire", "Concord"},
				{"New Jersey", "Trenton"},
				{"New York", "Albany"},
				{"New Mexico", "Santa Fe"},
				{"North Carolina", "Raleigh"},
				{"North Dakota", "Bismarck"},
				{"Ohio", "Columbus"},
				{"Oklahoma", "Oklahoma City"},
				{"Oregon", "Salem"},
				{"Pennsylvania", "Harrisburg"},
				{"Rhode Island", "Providence"},
				{"South Carolina", "Columbia"},
				{"South Dakota", "Pierre"},
				{"Tennessee", "Nashville"},
				{"Texas", "Austin"},
				{"Utah", "Salt Lake City"},
				{"Vermont", "Montpelier"},
				{"Virginia", "Richmond"},
				{"Washington", "Olympia"},
				{"West Virginia", "Charleston"},
				{"Wisconsin", "Madison"},
				{"Wyoming", "Cheyenne"}
		};
		List<String[]> arrayStateCap = new ArrayList<String[]>();
		for (int k = 0; k < stateCapital.length; k++) {
			String[] hold = {stateCapital[k][0], stateCapital[k][1]};
			int place = (int)(Math.random()*arrayStateCap.size());
			arrayStateCap.add(place, hold);
		}
		
		Scanner input = new Scanner(System.in);
		
		int correctCount = 0;
		
		
		for (int i = 0; i < arrayStateCap.size(); i++) {
			String[] holder = new String[2];
			holder = arrayStateCap.get(i);
			// Prompt the user with a question
			System.out.print("What is the capital of " + holder[0] + "? ");
			String capital = input.nextLine().trim().toLowerCase();
			
			if (capital.toLowerCase().equals(holder[1].toLowerCase())) {
				System.out.println("Your answer is correct");
				correctCount++;
			}
			
			else System.out.println("The correct answer should be " + holder[1]);
		}
		
		System.out.println("The correct count is " + correctCount);
	}
}
