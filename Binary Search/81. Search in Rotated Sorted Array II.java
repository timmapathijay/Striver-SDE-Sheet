class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0 , high = nums.length - 1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if(nums[mid] == target)
            return true;
            else if(nums[mid] == nums[low] && nums[mid] == nums[high])
            {
                low += 1;
                high -= 1;
                continue;
            }
            else if(nums[low] <= nums[mid]) // Left-half Sorted
            {
                if(nums[low] <= target && target < nums[mid])
                high = mid - 1;
                else
                low = mid + 1;
            }
            else // Right-half Sorted
            {
               if(nums[mid] < target && target <= nums[high])
               low = mid + 1;
               else
               high = mid - 1;
            }
        } 
        return false;
        
    }
}
