package simpleSorts;

public class linearSearch {

	public static void main(String[] args) {
		Integer[] nums1 = {1, 2, 3, 4, 5};
		System.out.println("List 1\n"+ print(nums1));
		System.out.println("Searching for 5");
		linearSearch(nums1, 5);
		
		
        Integer[] nums2 = {10, 20, 30, 40, 50};
        System.out.println("\nList 2\n"+ print(nums2));
		System.out.println("Searching for 5");
        linearSearch(nums2, 5);
        
        
        Integer[] nums3 = {5, 10, 15, 20, 25};
        System.out.println("\nList 3\n"+ print(nums3));
		System.out.println("Searching for 5");
        linearSearch(nums3, 5);
        
        Integer[] nums4 = {6, 10, 5, 20, 25};
        System.out.println("\nList 4\n"+ print(nums4));
		System.out.println("Searching for 5");
        linearSearch(nums4, 5);

	}





    private static <T> String print(T[] list) {
    	StringBuilder str= new StringBuilder("");
		for(int i =0; i < list.length; i ++) {
			str.append(list[i]+ " ");
		}
		return str.toString();
	}





	public static <T extends Comparable<T>> int linearSearch(T[] list, T target) {
        int comparisons=0;//to keep track of how many comparisons in the search
    	for (int i = 0; i < list.length; i++) {
            comparisons++;
            if (list[i].equals(target)) {
            	System.out.println("target was found after " + comparisons + " comparisons.");
                return i; // return index if found
            }
        }
    	System.out.println("Target was not found. "+ comparisons + " comparisons were made.");
        return -1; // return -1 if not found
    }

}  
