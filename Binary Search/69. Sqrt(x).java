class Solution {
    public int mySqrt(int x) {
        if(x == 1)
        return 1;
        int low = 1;
        int high = x/2;
        while(low <= high)
        {
            long mid = low + (high - low)/2;
            if(mid * mid <= x)
            low = (int)mid + 1;
            else
            high = (int)mid - 1;
        }
        return high;
    }
}
// TC : O(log(x/2))
// SC : O(1)
