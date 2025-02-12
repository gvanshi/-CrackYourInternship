import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0; 

        Arrays.sort(nums);
        return nums[nums.length / 2]; 
    }
}
