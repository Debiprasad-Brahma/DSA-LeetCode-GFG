# 🧠 Intuition
The array is **sorted**, which immediately suggests using **binary search**.

Instead of scanning the whole array to count occurrences of `x` (which would take \(O(n)\)), we can:
- Find the **first occurrence** of `x`
- Find the **last occurrence** of `x`

Then: count = lastIndex - firstIndex + 1

Why this works:
- All occurrences of `x` are **contiguous** in a sorted array.

---

# 🚀 Approach
1. Use binary search to find:
   - **First occurrence**:
     - Move left (`end = mid - 1`) even after finding `x`
   - **Last occurrence**:
     - Move right (`start = mid + 1`) even after finding `x`

2. If `firstOccurrence == -1`:
   - Element not present → return `0`

3. Otherwise:
   - Return `lastOccurrence - firstOccurrence + 1`

---

# ⏱ Complexity

- **Time complexity:**  
  $$O(\log n)$$  
  Two binary searches.

- **Space complexity:**  
  $$O(1)$$  
  No extra space used.

---

# 💻 Code
```java
public class Solution {
    public static int count(int arr[], int n, int x) {
        
        int firstOccurance = firstOccurance(arr, n, x);

        // If x is not present
        if (firstOccurance == -1) return 0;

        int lastOccurance = lastOccurance(arr, n, x);

        // Total count
        return lastOccurance - firstOccurance + 1;
    }

    // Find first occurrence
    static int firstOccurance(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;

        int first = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                first = mid;
                end = mid - 1; // move left
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return first;
    }

    // Find last occurrence
    static int lastOccurance(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;

        int last = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                last = mid;
                start = mid + 1; // move right
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return last;
    }
}
