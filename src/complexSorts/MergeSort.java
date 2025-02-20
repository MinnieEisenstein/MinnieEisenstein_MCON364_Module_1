package complexSorts;

import java.util.Random;

public class MergeSort {

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

        mergeSort(randomList);

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

        mergeSort(sortedList);

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

        mergeSort(reverseList);

        System.out.println("\nList after sorting:");
        for (int i = 0; i < reverseList.length; i++) {
            System.out.print(reverseList[i] + " ");
        }

	}
	
private static <T extends Comparable<T>> void mergeSort(T[] list) {
		
	}

}
