
# 📌 Problem: Number of Subarrays with Sum = Goal

## ❓ Question

You are given a binary array `nums` (containing only 0s and 1s) and an integer `goal`.

Return the number of non-empty subarrays of `nums` that sum to `goal`.

### ➕ Example:
```
Input: nums = [1, 0, 1, 0, 1], goal = 2  
Output: 4
```

### 📂 Explanation:

The subarrays with sum = 2 are:
- `[1, 0, 1]` (from index 0 to 2)
- `[1, 0, 1]` (from index 2 to 4)
- `[0, 1, 0, 1]` (from index 1 to 4)
- `[1, 0, 1]` (from index 0 to 2 again in overlapping perspective)

So the result is `4`.

---

## ✅ Answer (Java Code)

```java
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Initialize with base case: prefix sum = 0 has 1 frequency
        int sum = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];  // Running sum (prefix sum)

            // Check if there's a prefix that can form a valid subarray ending here
            if (map.containsKey(sum - goal)) {
                ans += map.get(sum - goal);
            }

            // Update frequency of current prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}
```

---

## 💡 Explanation of the Approach

### 🔍 Intuition:

To find subarrays with a sum equal to `goal`, we use **prefix sums** and a **HashMap** to track the frequency of each prefix sum.

The key idea is:
> If `prefixSum[i] - prefixSum[j] == goal`,  
> then the subarray from index `j` to `i-1` sums to `goal`.

This means:
- We maintain a running sum (`prefixSum`)
- At each index, check how many times the sum `(prefixSum - goal)` has occurred before
- Add that count to the result

### ⚙️ Steps:
1. Initialize a map to store prefix sums and their frequencies.
2. Set `map[0] = 1` to handle the case where a subarray starts from index 0.
3. Iterate through the array:
   - Update the prefix sum.
   - Check if `(prefixSum - goal)` exists in the map → add its frequency to the answer.
   - Update the map with the current prefix sum.

---

## ⏱️ Time and Space Complexity

### 🧮 Time Complexity:  
- **O(n)** → One pass through the array.

### 🗂️ Space Complexity:  
- **O(n)** → In the worst case, all prefix sums are unique.

---

## 🧠 When to Use This Approach

- When you are asked for **count of subarrays with a given sum**.
- Especially useful when array contains **non-negative numbers** or **binary values (0s and 1s)**.

---

## 🔗 Related Concepts

- Prefix Sum
- HashMap
- Subarray Count Problems
- Sliding Window (in some variations)

---

## 🏁 Final Notes

This method avoids nested loops and provides an optimal O(n) time solution for finding the number of subarrays with a fixed sum. It's a common and powerful pattern in competitive programming and technical interviews.
