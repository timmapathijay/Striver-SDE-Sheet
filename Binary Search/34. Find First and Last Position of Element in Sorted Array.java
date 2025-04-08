class Solution {
    private int findFirstOccurrence(int[] nums, int target){
        int firstOccurrence = -1;
        int low = 0 , high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
               firstOccurrence = mid;
               high = mid - 1; 
            }
            else if(nums[mid] < target)
            low = mid + 1;
            else
            high = mid - 1;
        }
        return firstOccurrence;
    }
    private int findLastOccurrence(int[] nums, int target){
        int lastOccurrence = -1;
        int low = 0 , high = nums.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
               lastOccurrence = mid;
               low  = mid + 1; 
            }
            else if(nums[mid] < target)
            low = mid + 1;
            else
            high = mid - 1;
        }
        return lastOccurrence;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[] = {-1 , -1};
        ans[0] = findFirstOccurrence(nums, target);
        if(ans[0] != -1)
        ans[1] = findLastOccurrence(nums, target);
        return ans;
    }
}
