import java.util.Arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 10, 9};
        
        // Sort the array in descending order
        Arrays.sort(nums);
        int n = nums.length;
        
        // The second largest element is at index n-2
        int secondLargest = nums[n-2];
        
        // Print the second largest element
        System.out.println("Second largest element: " + secondLargest);
    }
}
