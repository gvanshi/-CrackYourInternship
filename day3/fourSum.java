import java.util.*;
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return new AbstractList<List<Integer>>() {
            public List<Integer> get(int index) {
                init();
                return result.get(index);
            }

            public int size() {
                init();
                return result.size();
            }

            private void init() {
                if (result != null) {
                    return;
                }
                ArrayList<List<Integer>> answer = new ArrayList<>();
                if (nums.length < 4) {
                    result = answer;
                    return;
                }
                Arrays.sort(nums);
                int n = nums.length;
                int iLimit = n - 3;
                int jLimit = n - 2;

                for (int i = 0; i < iLimit; i++) {
                    if (i > 0 && nums[i] == nums[i - 1]) continue;

                    int iPlusOne = i + 1;
                    for (int j = iPlusOne; j < jLimit; j++) {
                        if (j > iPlusOne && nums[j] == nums[j - 1]) continue;
                        
                        int left = j + 1;
                        int right = n - 1;
                        long sum = (long) target - nums[i] - nums[j];
                        
                        while (left < right) {
                            long twoSum = nums[left] + nums[right];
                            if (twoSum == sum) {
                                answer.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                                while (left < right && nums[left] == nums[left + 1]) left++;
                                while (left < right && nums[right] == nums[right - 1]) right--;
                                left++;
                                right--;
                            } else if (twoSum < sum) {
                                left++;
                            } else {
                                right--;
                            }
                        }
                    }
                }
                result = answer;
            }
        };
    }
}
