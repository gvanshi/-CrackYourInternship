class Solution {
    public int maxArea(int[] height) {
        int r = height.length-1;
        int l = 0;
        int max = 0;
        while(l < r) {
            int minVal = Math.min(height[l], height[r]);
            max = Math.max(max, minVal*(r-l));
            while ( l < r && height[l] <= minVal) {
                l++;
            }
            while ( l < r && height[r] <= minVal) {
                r--;
            }
                
        }

        return max;
    }
}
