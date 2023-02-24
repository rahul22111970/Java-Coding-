import java.util.Arrays;

public class MaxMinElements {
    public static void main(String[] args) {
        int[] nums = {5, 2, 8, 10, 9};
        
        // Sort the array in ascending order
        Arrays.sort(nums);
        
        // The minimum element is at index 0
        int min = nums[0];
        
        // The maximum element is at index n-1
        int n = nums.length;
        int max = nums[n-1];
        
        // Print the minimum and maximum elements
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
    }
}
