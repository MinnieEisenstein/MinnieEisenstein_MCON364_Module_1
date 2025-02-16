package simpleSorts;

import java.util.Random;

public class BubbleSort {

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

        bubbleSort(randomList);

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

        bubbleSort(sortedList);

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

        bubbleSort(reverseList);

        System.out.println("\nList after sorting:");
        for (int i = 0; i < reverseList.length; i++) {
            System.out.print(reverseList[i] + " ");
        }
    }

    private static <T extends Comparable<T>> void bubbleSort(T[] list) {
        int size = list.length;
        boolean swapped = true;

        while (swapped) { // run while swaps are happening
            swapped = false;
            for (int i = 0; i < size - 1; i++) { // go thru the list
                if (list[i].compareTo(list[i + 1]) > 0) { // if a pair is out of order
                    // swap them
                    T temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swapped = true;
                }
            }
            size--; // reduce the range after each pass
        }
    }
}


/*
 Analyzing the time complexity and space complexity
the best case is O(n), but the average case and worst case are O(n^2).
it works by comparing each pair of adjacent elements and swapping them if they are in the wrong order.
this process is repeated until the list is fully sorted.
if the list is already sorted, the algorithm can stop early after one pass.
but in the worst case (when the list is reversed), it still has to go through the entire list multiple times,
 making it O(n^2).

space complexity- is O(1)
it doesn’t need any extra memory because it swaps elements in place.
the only extra space it uses is for the temp variable used for the swapping.

it swaps whenever two adjacent elements are in the wrong order.
this means in the worst case, elements can be swapped many times per iteration as they move toward their correct position.
it keeps passing through the list until no more swaps are needed.
if the list is already sorted, it doesn’t swap at all and stops early.
but if the list is reversed, the largest elements take tons of swaps to move to their correct place.
 */
