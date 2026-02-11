## 🪟 Maximum Sum Subarray of Size K

### Intuition  
We are given an array and a fixed window size `k`.  
The goal is to find the **maximum sum of any contiguous subarray of size `k`**.

Instead of recalculating the sum for every possible subarray (which would be O(nk)), we can use a **sliding window technique**.

Key idea:
- Calculate the sum of the first `k` elements.
- Slide the window one step at a time:
  - Add the new element entering the window.
  - Subtract the element leaving the window.

This keeps the time complexity linear.

---

### Approach  
1. Compute the sum of the first `k` elements.
2. Store it as the initial maximum.
3. Start sliding the window:
   - For each new element `arr[j]`,
     - Add `arr[j]`
     - Subtract the element at the start of the previous window
4. Update the maximum sum at each step.
5. Return the maximum sum found.

---

### Time & Space Complexity  
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

### Code  
```java
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;

        // Initial window sum
        int currSum = 0;
        for (int i = 0; i < k; i++) {
            currSum += arr[i];
        }

        int ans = currSum;
        int i = 0;

        // Slide the window
        for (int j = k; j < n; j++) {
            currSum = currSum + arr[j] - arr[i];
            i++;
            ans = Math.max(ans, currSum);
        }

        return ans;
    }
}
