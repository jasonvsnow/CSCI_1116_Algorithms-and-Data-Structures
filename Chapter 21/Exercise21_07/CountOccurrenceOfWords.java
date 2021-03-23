package exercise21_07;

import java.util.*;

/*
 * Author: Jason Snow
 * Date: 03/23/2021
 * 
 * This program was rewritten so that after the each unique word from a string was stored in a map and the number of 
 * the words occurrences in that string were tracked in the same map, the maps contents would be displayed in ascending order of occurrence counts.
 */

public class CountOccurrenceOfWords {
	public static void main(String[] args) {
		// Set text in a string
		String text = "Good morning. Have a good class. " +
			"Have a good visit. Have fun!";

		// Create a TreeMap to hold words as key and count as value
		Map<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
		ArrayList<WordOccurence> count = new ArrayList<>();
		
		
		String[] words = text.split("[\\s+\\p{P}]");
		for (int i = 0; i < words.length; i++) {
			String key = words[i].toLowerCase();
			
			if (key.length() > 0) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
					count.add(new WordOccurence(key, 1));
				}
				else {
					int value = map.get(key);
					value++;
					map.put(key, value);
					for (int j = 0; j < count.size(); j++) {
						WordOccurence compare = count.get(j);
						if (compare.getWord().equalsIgnoreCase(key)) {
							compare.setCount(compare.getCount()+1);
						}
					}
					
				}
			}
		}
		Collections.sort(count);
		for (int i = 0; i < count.size(); i++) {
			map.get(count.get(i).getWord());
		}
		// Display key and value for each entry
		map.forEach((k, v) -> System.out.println(k + "\t" + v));

	}
}