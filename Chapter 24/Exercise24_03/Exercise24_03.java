package exercise24_03;

/*
 * Author: Jason Snow
 * Date: 03/23/2021
 * 
 * This program was edited to create a doubly linked list out of a simple linked list.
 * 
 */

class Exercise24_03 {
	public static void main(String[] args) {
		TwoWayLinkedList<Integer> list = new TwoWayLinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		java.util.ListIterator<Integer> iterator = list.iterator();
		iterator.next();
		iterator.next();
		iterator.next();
		
		
		//System.out.print(iterator.next() + " ");

		System.out.println();
		while (iterator.hasPrevious())
		   System.out.print(iterator.previous() + " ");
	}
}
