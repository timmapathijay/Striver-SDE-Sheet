class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        // distinct elements pairing 
        int majorityElement = nums[0];
        int freq = 1;
        for(int i = 1; i < n; i++)
        {
            if(nums[i] == majorityElement)
            {
                freq++;
            }
            else
            {
                if(freq > 0)
                freq--;
                else
                {
                    // unpaired-element
                    freq = 1;
                    majorityElement = nums[i]; 
                }
            }
        }
        return majorityElement;
    }
}
// TC : O(N)
// SC : O(1)
