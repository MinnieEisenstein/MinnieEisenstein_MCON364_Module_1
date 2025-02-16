package simpleSorts;

import java.util.Random;

public class SelectionSort {

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

        selectionSort(randomList);

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

        selectionSort(sortedList);

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

        selectionSort(reverseList);

        System.out.println("\nList after sorting:");
        for (int i = 0; i < reverseList.length; i++) {
            System.out.print(reverseList[i] + " ");
        }
        
    }

    private static <T extends Comparable<T>> void selectionSort(T[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i; // track index of the lowest value

            for (int j = i + 1; j < list.length; j++) { // go thru list and find the lowest
                if (list[j].compareTo(list[minIndex]) < 0) { // Use compareTo() instead of <
                    minIndex = j;
                }
            }
            // swap lowest for the first unsorted number
            T temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }
}


/*
 Analyzing the time complexity and space complexity
 the best case, average case and worst case is O(n^2).
 it works by finding the smallest element and swapping it with the first unsorted element. 
 and then repeating process the amnt of times- the size of the list.
 even if the list is already sorted- it cannot assume that, and it still needs to go through the list for each one.
 
 space complexity- is O(1)
 it doesn't need any extra memory because it swaps the elements in place. 
 The only extra space it uses is for the temp variable that is used for the swapping.
 
 it swaps every time it finds a smaller element in the unsorted part of the list.
for each element, it looks through the rest of the list to find the smallest one and swaps it with the current element.
this means it only swaps once per each iteration(going thru list), even if tons elements are out of order.
since it always does the same number of comparisons, it doesn’t gain anything from an already sorted list 
and still has to go through all elements.
 */
