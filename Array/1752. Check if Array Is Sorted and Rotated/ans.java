class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i] > nums[(i+1) % n]) count++; // For last element compared with first
        }
        if(count > 1) return false; // If the count is greater than 1
        return true;
    }
}
