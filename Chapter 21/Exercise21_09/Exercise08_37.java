package exercise21_09;

import java.util.*;
/*
 * Author: Jason Snow
 * Date: 03/24/2021
 * 
 * This program was modified to, instead of being a guessing game for state capitals, prompt a user to enter a state and display
 * the capital of that state, provided the state exists. 
 */

public class Exercise08_37 {
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
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < stateCapital.length; i++) {
    	map.put(stateCapital[i][0], stateCapital[i][1]);
    }
    

    Scanner input = new Scanner(System.in);
    
    boolean doing = true;
    while (doing) {
    	System.out.print("Enter a state to get its capital(or enter Exit to exit the program): ");
    	String find = input.nextLine();
    	if (find.equalsIgnoreCase("exit")) {
    		System.out.print("Have a good day! :)");
    		doing = false;
    	}
    	else {
    		if (map.containsKey(find)) {
    			System.out.println("The capital of " + find + " is " + map.get(find));
    		}
    		else System.out.println("No state found with that name. The program is case sensitive and double check your spelling.");
    	}
    	
    }
  }
}
