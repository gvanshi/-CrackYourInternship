class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max=0;
        int sum=0;
        for(int i=0;i<k;i++){
            sum+=cardPoints[i];
        }
        max=sum;
        int right=cardPoints.length-1;
        int left=k-1;
        while(left>=0){
            sum=sum-cardPoints[left]+cardPoints[right];
            left--;
            right--;
            if(max<sum){
                max=sum;
            }
        }
        return max;
    }
}
