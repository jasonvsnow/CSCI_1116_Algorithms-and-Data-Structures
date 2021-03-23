package exercise24_01;

import java.util.*;
/*
 * Author: 
 * Date: 03/21/2021
 * 
 * This program, several various classes, was edited to define and implement methods to add all
 * elements from one list to another, remove all elements from a list that exist in another list,
 * and retain all shared elements between two lists for one. It then displays this working, setting two
 * lists repeatedly, printing them, running an operation on one with the other, and displaying the result.
 */
public class Exercise24_01 {
  public static void main(String[] args) {
    new Exercise24_01();
  }

  public Exercise24_01() {
    String[] name1 = {"Tom", "George", "Peter", "Jean", "Jane"};
    String[] name2 = {"Tom", "George", "Michael", "Michelle", "Daniel"};
    
    MyList<String> list1 = new MyArrayList<String>(name1);   
    MyList<String> list2 = new MyArrayList<String>(name2);   
    System.out.println("list1:" + list1);
    System.out.println("list2:" + list2);
    list1.addAll(list2);
    System.out.println("After addAll:" + list1 + "\n");
    
    list1 = new MyArrayList<String>(name1);
    list2 = new MyArrayList<String>(name2);   
    System.out.println("list1:" + list1);
    System.out.println("list2:" + list2);
    list1.removeAll(list2);
    System.out.println("After removeAll:" + list1 + "\n");
    
    list1 = new MyArrayList<String>(name1);
    list2 = new MyArrayList<String>(name2);   
    System.out.println("list1:" + list1);
    System.out.println("list2:" + list2);
    list1.retainAll(list2);
    
    System.out.println("After retainAll:" + list1 + "\n");
  }
}
