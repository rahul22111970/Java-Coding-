import java.util.HashSet;

public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        
        // Add all numbers from 0 to n to the HashSet
        for (int i = 0; i <= n; i++) {
            set.add(i);
        }
        
        // Remove all numbers present in the array from the HashSet
        for (int i = 0; i < n; i++) {
            set.remove(nums[i]);
        }
        
        // The remaining number in the HashSet is the missing number
        for (int num : set) {
            return num;
        }
        
        // If no missing number is found, return -1
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 4, 5};
        int missingNumber = findMissingNumber(nums);
        System.out.println("Missing number: " + missingNumber);
    }
}
