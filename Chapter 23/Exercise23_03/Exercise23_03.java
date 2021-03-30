package exercise23_03;



/*
 * Author: Jason Snow
 * Date: 03/30/21
 * 
 * This program was edited to include the quickSort methods and partition methods. One type extends comparable, while another uses a comparator
 * provided when calling the method. Each type use the same quickSort set-up to sort arrays.
*/
import java.util.*;

public class Exercise23_03 {
	public static void main(String[] args) {
		Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
		quickSort(list);
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		
		System.out.println();
		Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
				new Circle(5), new Circle(6), new Circle(1), new Circle(2),
				new Circle(3), new Circle(14), new Circle(12)};
		quickSort(list1, new GeometricObjectComparator());
		for (int i = 0; i < list1.length; i++) {
			System.out.println(list1[i] + " ");
		}
	}
	
	
	
	
	//sort methods
	public static <E extends Comparable<E>> void quickSort(E[] list) {
		quickSort(list, 0, list.length -1);
	}
	public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
		quickSort(list, comparator, 0, list.length-1);
	}
	
	//helper methods
	public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last){
		if (last > first)  {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex-1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	public static <E> void quickSort(E[] list, Comparator<? super E> comparator, int first, int last){
		if (last > first)  {
			int pivotIndex = partition(list, comparator, first, last);
			quickSort(list, comparator, first, pivotIndex-1);
			quickSort(list, comparator, pivotIndex + 1, last);
		}
	}
	
	
	//partition methods
	public static <E extends Comparable<E>> int partition(E[] list, int first, int last){
		E pivot = list[first];
		int low = first+1;
		int high = last;
		
		while (high > low) {
			while (low <= high && list[low].compareTo(pivot) <= 0) low++;
			
			while (low <= high && list[high].compareTo(pivot) > 0) high--;
			
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && list[high].compareTo(pivot) >= 0) high--;
		
		if (pivot.compareTo(list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		
		else return first;
	}
	
	
	public static <E> int partition(E[] list, Comparator<? super E> comparator, int first, int last){
		E pivot = list[first];
		int low = first+1;
		int high = last;
		
		while (high > low) {
			while (low <= high && comparator.compare(list[low], pivot) <= 0) low++;
			
			while (low <= high && comparator.compare(list[high], pivot) > 0) high--;
			
			if (high > low) {
				E temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		while (high > first && comparator.compare(list[high], pivot) >= 0) high--;
		
		if (comparator.compare(pivot, list[high]) > 0) {
			list[first] = list[high];
			list[high] = pivot;
			return high;
		}
		
		else return first;
	}
}
