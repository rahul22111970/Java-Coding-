public class AscendingOrder {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        
        // Check if the array is sorted in ascending order
        boolean isAscending = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                isAscending = false;
                break;
            }
        }
        
        // Print whether the array is sorted in ascending order
        if (isAscending) {
            System.out.println("The array is sorted in ascending order.");
        } else {
            System.out.println("The array is not sorted in ascending order.");
        }
    }
}
