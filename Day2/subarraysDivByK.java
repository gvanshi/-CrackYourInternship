class Solution {
    public int subarraysDivByK(int[] nums, int k) 
    {
        int [] counts=new int[k];
        int sum=0;
        for(int x:nums)
        {
            sum+=x;
            int rem=sum%k;
            if(rem<0)
                rem=rem+k;

            counts[rem]++;
        }

        int result=counts[0];
        for(int rem:counts)
        {
            result+=(rem*(rem-1))/2;
        }
        return result;
    }
}
