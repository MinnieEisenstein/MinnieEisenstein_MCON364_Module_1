package complexSorts;

import java.util.Random;

public class ComplexSortsQuiz {

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
        
        

	}
	
	private static <T extends Comparable<T>> void quickSort(T[] list, int low, int high) {
		if (low <high) {
			int pivotIndex = partition(list, low, high);
			
			//recursively sort each side of partition
			quickSort(list, low, pivotIndex-1);
			quickSort(list, pivotIndex+1, high);
			
		}
	}

	private static <T extends Comparable<T>>int partition(T[] list, int low, int high) {
		T pivot = list[high];//pick last element as pivot
		int smallerIndex= low-1;//initialize it to before lowest index
		//go thru list
		for(int currIndex = low; currIndex < high; currIndex++) {
			//if its smaller than pivot, move to the left..
			if(list[currIndex].compareTo(pivot) < 0) {
				smallerIndex++;
				T temp = list[smallerIndex];
				list[smallerIndex]= list[currIndex];
				list[currIndex]= temp;
	
			}
		}
		//put pivot in place
		T temp = list[smallerIndex+1];
		list[smallerIndex+1]= list[high];
		list[high]= temp;
		
		
		
		return smallerIndex+1;
		
	}
	
	private static <T extends Comparable<T>> void heapSort(T[] list) {
		int size = list.length;
		//assuming that heap is heapified already
		for (int i = size-1; i > 0; i--) {
			//start from last element of list- and swap with the largest element-top of the heap-index 0
			T temp = list[0];
			list[0]= list[i];
			list[i]= temp;
			
			heapify(list, 0,size); //call the heapify method passing in the root and the size
		}
	}

	private static void heapify(T[] list, int root, int high) {
		//did not need to implement for the quiz
		
	}
}
