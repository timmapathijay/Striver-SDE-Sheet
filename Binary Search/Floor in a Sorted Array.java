class Solution {

    static int findFloor(int[] arr, int x) {
        int floor = -1;
        int low = 0 , high = arr.length - 1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] <= x)
            {
                floor = mid;
                low = mid + 1;
            }
            else
            high = mid - 1;
        }
        return floor;
    }
}
// TC : O(log N)
// SC : O(1)
