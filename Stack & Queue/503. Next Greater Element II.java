class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int NGER[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
        {
           while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
           NGER[stack.pop()] = nums[i];

           stack.push(i); 
        }
        for(int i = 0; i < n; i++)
        {
           while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
           NGER[stack.pop()] = nums[i];

        }

        while(!stack.isEmpty())
        NGER[stack.pop()] = -1;

        return NGER;
    }
}
// TC : N + N + N[Stack-Loop] => O(3N)
// SC : O(N)
