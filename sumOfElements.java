public class SumOfElements {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        
        // Calculate the sum of elements in the array
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        // Print the sum of elements
        System.out.println("Sum of elements: " + sum);
    }
}
