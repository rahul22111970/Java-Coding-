import java.util.HashMap;

public class MajorityElement {
    public static int findMajorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        // Count the frequency of each element in the array
        for (int i = 0; i < n; i++) {
            int key = nums[i];
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        
        // Check if any element appears more than n/2 times
        for (int key : countMap.keySet()) {
            if (countMap.get(key) > n/2) {
                return key;
            }
        }
        
        // No majority element found
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 2};
        int majorityElement = findMajorityElement(nums);
        System.out.println("Majority element: " + majorityElement);
    }
}
