class Solution {
    public int maxSubArray(int[] nums) {
        int subarraySum = 0;
        int ans = nums[0];
        for(int i = 0; i < nums.length; i++)
        {
            subarraySum += nums[i];
            ans = Math.max(ans , subarraySum);
            if(subarraySum < 0)
            subarraySum = 0;
        }
        return ans;
    }
}
// TC : O(N)
// SC : O(1)
