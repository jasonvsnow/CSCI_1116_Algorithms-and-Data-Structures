package exercise24_05;


/*
 * Author: Jason Snow
 * Date: 03/23/2021
 * 
 * This is the test for a GenericQueue class created to extend LinkedList and implement two methods; enqueue and dequeue which add elements to the 
 * end of the queue or remove them from the front of it. This test class shows the effects of these methods.
 */
public class Exercise24_05 {
	public static void main(String[] args) {
		GenericQueue<String> queue = new GenericQueue<>();
		System.out.println("Empty queue: " + queue);
		System.out.println();
		String enque = "Tom";
		System.out.println("String to enqueue: " + enque);
		queue.enqueue(enque);
		System.out.println("After enqueue: " + queue);
		String sue = "Susan";
		String bo = "Bob";
		System.out.println("Additional enqueues: " + sue + ", " + bo);
		queue.enqueue(sue);
		queue.enqueue(bo);
		System.out.println("After additioanl enqueues: " + queue);
		
		System.out.println();
		System.out.println("Element removed in dequeue: " + queue.dequeue());
		System.out.print("Queue after dequeue: " + queue);
		
		
		
		
	}
} 
