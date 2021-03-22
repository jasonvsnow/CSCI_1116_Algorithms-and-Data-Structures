package exercise20_21;

/*
Author: Jason Snow
Date: 03/22/2021

Description: This is a test program that invokes the GeometricObjectComparator comparator and selection sort to sort lists of elements, then displays them.
*/
import java.util.*;

public class Exercise20_21 {
  public static void main(String[] args) {
    GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
        new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5), 
        new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
        new Circle(6.5), new Rectangle(4, 5)};

    Circle[] list1 = {new Circle(2), new Circle(3), new Circle(2),
      new Circle(5), new Circle(6), new Circle(1), new Circle(2),
      new Circle(3), new Circle(14), new Circle(12)};
    
    System.out.println("First List Sorted: ");
    selectionSort(list1, new GeometricObjectComparator());
    for (int i = 0; i < list1.length; i++)
      System.out.println(list1[i].getArea() + " ");
    
    
    System.out.println("\nSecond List Sorted: ");
    selectionSort(list, new GeometricObjectComparator());
    for (int i = 0; i < list.length; i++)
      System.out.println(list[i].getArea() + " ");
    
  }
  
  public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
	  E currentMin;
	  int currentMinIndex;
	  
	  for (int i = 0; i < list.length - 1; i++) {
		  currentMin = list[i];
		  currentMinIndex = i;
		  
		  for (int j = i + 1; j < list.length; j++) {
			  if (comparator.compare(list[currentMinIndex], list[j]) > 0) {
				  currentMin = list[j];
				  currentMinIndex = j;
			  }
		  }
		  
		  if (currentMinIndex != i) {
			  list[currentMinIndex] = list[i];
			  list[i] = currentMin;
		  }
		  
	  }
  }
  
}