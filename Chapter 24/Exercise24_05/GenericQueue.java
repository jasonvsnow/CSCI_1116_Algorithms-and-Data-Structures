package exercise24_05;

import java.util.*;

public class GenericQueue<E> extends LinkedList<E> {

	public void enqueue(E e) {
		addLast(e);
	}
	public E dequeue() {
		return removeFirst();
	}
	public int getSize() { 
		return size();
	}

}
