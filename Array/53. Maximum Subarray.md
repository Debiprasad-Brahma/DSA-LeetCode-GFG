# Maximum Subarray Problem (Kadane's Algorithm)

## Problem Statement
Given an integer array `nums`, find the **contiguous subarray** (containing at least one number) which has the largest sum and return its sum.

---

## Approach
We use **Kadane's Algorithm** to solve this problem in **O(n)** time and **O(1)** space.

### Algorithm Steps:
1. Initialize:
   - `ans` as the first element of the array (to handle all-negative cases).
   - `sum` as 0 to store the current subarray sum.
2. Iterate through each element `num` in `nums`:
   - If `sum` becomes negative, reset it to `0` (start a new subarray).
   - Add `num` to `sum`.
   - Update `ans` to the maximum of `ans` and `sum`.
3. Return `ans`.

---

## Java Implementation
```java
class Solution {
    public int maxSubArray(int[] nums) {
       int ans = nums[0];
       int sum = 0;

       for(int num : nums){
           if(sum < 0) sum = 0;
           sum += num;
           ans = Math.max(ans, sum); 
       }
       return ans;
    }
}
