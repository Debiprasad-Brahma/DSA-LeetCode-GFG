# Check if Array is Sorted and Rotated

## Overview
This algorithm checks whether a given integer array is sorted in non-decreasing order and possibly rotated.  
A rotation means elements from the start are moved to the end while preserving the overall sorted order.

---

## Intuition
If an array is sorted and rotated, it will have **at most one point** where an element is greater than its next element (considering circular comparison).  
This is because:
- A purely sorted array has `0` such points.
- A sorted array rotated once has exactly `1` such point.
- If there are more than `1` such points, the array cannot be sorted and rotated.

Example:  
- `[3, 4, 5, 1, 2]` → One break at `5 > 1` → ✅ Sorted & Rotated  
- `[2, 1, 3, 4]` → Two breaks → ❌ Not Sorted & Rotated  

---

## Approach
1. Initialize a counter `count` to track the number of breaks in ascending order.
2. Iterate through the array:
   - Compare `nums[i]` with `nums[(i + 1) % n]` (circular check).
   - If `nums[i] > nums[(i + 1) % n]`, increment `count`.
3. After the loop:
   - If `count > 1`, return `false`.
   - Else, return `true`.

---

## Implementation
```java
class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1; // I just changed it here
    }
}
