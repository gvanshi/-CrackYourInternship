import java.util.AbstractList;
class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> threeSum(int[] nums) {
        return new AbstractList<List<Integer>>() {

            public int size() {
                init();
                return result.size();
            }

            public List<Integer> get(int index) {
                init();
                return result.get(index);
            }

            private void init(){
                if(result != null)
                    return;

                ArrayList<List<Integer>> res = new ArrayList<>();

                Arrays.sort(nums);

                for(int i = 0; i < nums.length; i++){
                    if(i != 0 && nums[i - 1] == nums[i]) continue;
                    twoPointersExtended(i, res);
                }

                result = res;
            }

            private  void twoPointersExtended(int targetIdx, List<List<Integer>> result){
                int target = -nums[targetIdx];
                int left = targetIdx + 1, right = nums.length - 1;
                while(left < right){
                    
                    if(nums[left] + nums[right] == target){
                        result.add(Arrays.asList(-target, nums[left], nums[right]));
                        left++; right --;
                    }
                    else if(nums[left] + nums[right] < target) left++;
                    else if(nums[left] + nums[right] > target) right--;

                    while(left < right && right < nums.length - 1 && nums[right] == nums[right + 1]){
                        right --;
                    }
                }
            }
        };
    }
}
