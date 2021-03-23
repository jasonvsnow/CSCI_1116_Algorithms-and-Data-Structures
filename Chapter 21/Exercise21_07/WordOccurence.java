package exercise21_07;

import java.util.*;

public class WordOccurence implements Comparable<WordOccurence> {
	private String word;
	private int count;
	
	public WordOccurence() {
		
	}
	public WordOccurence(String word, int count) {
		this.word = word;
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}
	
	@Override
	public int compareTo(WordOccurence o) {
		if (getCount() > o.getCount()) {
			return 1;
		}
		else if (getCount() < o.getCount()) {
			return -1;
		}
		else return 0;
	}
	
	
	
}
