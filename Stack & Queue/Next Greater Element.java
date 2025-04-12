class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(n);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++)
        ans.add(-1);
        
        for(int i = 0; i < n; i++) 
        {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) 
            {
                ans.set(stack.pop() , arr[i]);
            }
            stack.push(i);
        }
        return ans;
    }
}
// TC : N + N + N => O(3N)
// SC : O(N)
