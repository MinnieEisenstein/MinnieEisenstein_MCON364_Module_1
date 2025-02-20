package complexSorts;

import java.util.Random;

public class Quicksort {

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

        quickSort(randomList, 0 ,randomList.length-1);

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

        quickSort(sortedList, 0 , sortedList.length-1);

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

        quickSort(reverseList, 0, reverseList.length-1);

        System.out.println("\nList after sorting:");
        for (int i = 0; i < reverseList.length; i++) {
            System.out.print(reverseList[i] + " ");
        }

	}
	
	private static <T extends Comparable<T>> void quickSort(T[] list, int low, int high) {
		if (low< high) {
			int pivotIndex =partition(list, low, high);//get the index of pivot
			
			//recursively sort list before and after pivot
			quickSort(list, low, pivotIndex-1);
			quickSort(list, pivotIndex +1, high);
		}
		
	}

	private static <T extends Comparable<T>>int partition(T[] list, int low, int high) {
		T pivot = list[high];//picking the last element as pivot
		int smallerElementIndex = low-1;
		
		//go thru the list- elements bigger than pivot go to the right, and smaller to left
		for(int currIndex =low; currIndex < high; currIndex++) {
			if(list[currIndex].compareTo(pivot)<0) {//element is smaller than pivot
				smallerElementIndex++;//keep track of where the next smallest element should go
				//swap
				T temp = list[smallerElementIndex];
		        list[smallerElementIndex] = list[currIndex];
		        list[currIndex] = temp;   				
			}
		}
		
		//put pivot in correct place by swapping
		T temp =list[smallerElementIndex+1];//location to put pivot
		list[smallerElementIndex+1]= list[high];
		list[high] =temp;
		
		//return new index of recent pivot- do the quicksort starting from there next time
		
		return smallerElementIndex+1;
	}

}
