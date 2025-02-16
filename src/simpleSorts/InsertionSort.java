package simpleSorts;

import java.util.Random;

public class InsertionSort {

	public static void main(String[] args) {
		//List with random numbers
        Integer[] randomList = new Integer[10]; 
        Random rand = new Random();

        System.out.println("List before sorting:(random list)");
        //populate the array with random numbers
        for (int i = 0; i < randomList.length; i++) {
            randomList[i] = rand.nextInt(21);
            System.out.print(randomList[i] + " ");
        }

        insertionSort(randomList);

        System.out.println("\nList after sorting:");
        for (int i = 0; i < randomList.length; i++) {
            System.out.print(randomList[i] + " ");
        }
        
        
        //sorted list
        
        Integer[] sortedList = new Integer[10] ; 

        System.out.println("\n\nList before sorting:(sorted list)");
        int x =1;
        for (int i = 0; i < sortedList.length; i++) {
        	
        	sortedList[i]= x++;
            System.out.print(sortedList[i] + " ");
        }

        insertionSort(sortedList);

        System.out.println("\nList after sorting:");
        for (int i = 0; i < sortedList.length; i++) {
            System.out.print(sortedList[i] + " ");
        }
        
        //sorted list
        
        Integer[] reverseList = new Integer[10] ; 

        System.out.println("\n\nList before sorting:(reverse list)");
        int y =11;
        for (int i = 0; i < reverseList.length; i++) {
        	
        	reverseList[i]= x--;
            System.out.print(reverseList[i] + " ");
        }

        insertionSort(reverseList);

        System.out.println("\nList after sorting:");
        for (int i = 0; i < reverseList.length; i++) {
            System.out.print(reverseList[i] + " ");
        }

	}

	private static <T extends Comparable<T>> void insertionSort(T[] list) {
		for(int i = 1; i < list.length; i ++) {
			T element = list[i];//start from second element in list
			int prevElement = i-1;
			if(element.compareTo(list[i-1]) < 0) {
				//the element we are looking at is in wrong place
				//find the correct place it belongs and insert it there
		
			    while(prevElement >=0 && list[prevElement].compareTo(element) > 0) {
			    	list[prevElement + 1] = list[prevElement];//shift everything
			    	prevElement--;//decrease prevElement
			    }
			    //put element in correct place
			    list[prevElement + 1] = element;
			}
		}
	}
}

/*
 Analyzing the time complexity and space complexity
the best case is O(n), but the average case and worst case are O(n^2).
it works by taking each element and placing it in the correct position relative to the already sorted part of the list.
if the list is already sorted, it only makes one pass without shifting elements, making it O(n).
but in the worst case (when the list is reversed), every element must be compared with each previous one and shifted, leading to O(n^2).

space complexity- is O(1)
it doesn’t need any extra memory because it shifts elements in place.
the only extra space it uses is for the temp variable that holds the value being inserted.

it swaps by shifting elements instead of actual swapping.
if an element is in the wrong place, it moves left one step at a time until it reaches its correct position.
this means an element can be moved multiple times in a single iteration if it's rlly far from where it belongs.
if the list is already sorted, it never swaps, since each element is already in the right place.
but if the list is reversed, every element has to be moved all the way to the front, making it worst case.
 */
