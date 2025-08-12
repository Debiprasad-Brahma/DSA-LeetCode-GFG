class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int []ans= new int[nums.length];
        Arrays.fill(ans,-1);
        int n=nums.length;
        Stack<Integer> stk = new Stack<>();

        // Loop from 2*n - 1 down to 0 to simulate a circular array
        for(int i=2*n-1; i>=0; i--){  

            // Pop smaller or equal elements from the stack (they can't be "next greater")
            while(!stk.isEmpty() && nums[stk.peek()] <= nums[i % n])
            stk.pop();

            // Only fill the result for first n indices
            if(i < n)
            ans[i % n] = stk.isEmpty() ? -1 : nums[stk.peek()];

            // Push current index (modulo n for circular effect)
            stk.push(i % n);
        }
        return ans;
    }
}


//GFG part
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        
        for (int i = n * 2 - 1; i >= 0; i--) {
            while (!stk.isEmpty() && arr[stk.peek()] <= arr[i % n]) {
                stk.pop();
            }
            if (i < n) {
                res[i] = stk.isEmpty() ? -1 : arr[stk.peek()];
            }
            stk.push(i % n);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for (int val : res) ans.add(val);
        return ans;
    }
}
