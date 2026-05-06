# 🔥 Longest Subarray with Sum K | Sliding Window O(N) | Non-Negative Arrays | Zero Extra Space

---

## 💡 Intuition

The brute force checks **every possible subarray** — O(N²) or O(N³). Too slow.

> Key Insight: For **non-negative arrays**, the subarray sum is **monotonically non-decreasing** as we expand right. This makes it a perfect **Sliding Window** candidate.

Think of it like a rubber band stretched over numbers:
- **Expand right** → sum grows
- **Shrink left** → sum decreases
- **Sum == K** → record the length

We never need to go backwards because adding non-negative numbers never decreases the sum.

> ⚠️ **Critical Caveat:** This approach works **only for non-negative integers**.  
> For arrays with **negative numbers** → use **HashMap + Prefix Sum** approach instead.

---

## 🧠 Approach — Two Pointer Sliding Window

1. Maintain a window `[start, end]` with running `sum`.
2. **Expand** window by moving `end` right → add `a[end]` to sum.
3. **Shrink** window by moving `start` right → subtract `a[start]` while `sum > k`.
4. If `sum == k` → update `maxLen = max(maxLen, end - start + 1)`.
5. Return `maxLen`.

---

## 📊 Dry Run

```
a = [1, 2, 3, 1, 1, 1, 1],  k = 6
```

| end | a[end] | sum | start | Window | Action |
|-----|--------|-----|-------|--------|--------|
| 0   | 1      | 1   | 0     | [1]           | sum < k |
| 1   | 2      | 3   | 0     | [1,2]         | sum < k |
| 2   | 3      | 6   | 0     | [1,2,3]       | ✅ sum==k → maxLen=3 |
| 3   | 1      | 7   | 0     | [1,2,3,1]     | sum > k → shrink |
|     |        | 6   | 1     | [2,3,1]       | ✅ sum==k → maxLen=3 |
| 4   | 1      | 7   | 1     | [2,3,1,1]     | sum > k → shrink |
|     |        | 6   | 2     | [3,1,1]       | ✅ sum==k → maxLen=3 |
| 5   | 1      | 7   | 2     | [3,1,1,1]     | sum > k → shrink |
|     |        | 6   | 3     | [1,1,1]       | ✅ sum==k → maxLen=3 |
| 6   | 1      | 7   | 3     | [1,1,1,1]     | sum > k → shrink |
|     |        | 6   | 4     | [1,1,1]       | ✅ sum==k → maxLen=3 |

**Output:** `3` ✅

---

## 🧪 Edge Cases

```
a = [1, 2, 3],       k = 6   →  3  (entire array)
a = [1, 2, 3],       k = 0   →  0  (no subarray, all positive)
a = [3],             k = 3   →  1  (single element)
a = [1, 1, 1, 1, 1], k = 5   →  5  (entire array)
a = [5, 1, 2],       k = 3   →  2  (subarray [1,2])
```

---

## ✅ Code (Java)

```java
public class Solution {
    public static int longestSubarrayWithSumK(int[] a, long k) {
        int n = a.length;
        long sum = 0;
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < n; end++) {
            sum += a[end];                        // Expand window → add right element

            // Shrink from left while sum exceeds k
            while (sum > k && start <= end) {
                sum -= a[start++];                // Shrink window → remove left element
            }

            // Valid window found → update answer
            if (sum == k) {
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }

        return maxLen;
    }
}
```

---

## ⏱ Complexity Analysis

| | Complexity | Reason |
|---|---|---|
| **Time** | O(N) | Each element is added and removed from window **at most once** |
| **Space** | O(1) | Only pointers and a running sum — no extra array |

> 💡 Even though there's a `while` loop inside `for`, `start` only moves forward — total moves across entire run = **N**. So it's truly O(N), not O(N²).

---

## ⚔️ Sliding Window vs HashMap Prefix Sum

| | Sliding Window ✅ | HashMap + Prefix Sum |
|---|---|---|
| **Works for** | Non-negative integers only | All integers (including negatives) |
| **Time** | O(N) | O(N) |
| **Space** | O(1) | O(N) |
| **When to use** | Constraints say non-negative | Array has negative numbers |

### HashMap Prefix Sum (for negative arrays):
```java
// When array contains negative numbers
Map<Long, Integer> map = new HashMap<>();
map.put(0L, -1);    // Empty prefix
long sum = 0;
int maxLen = 0;

for (int i = 0; i < n; i++) {
    sum += a[i];
    if (map.containsKey(sum - k)) {
        maxLen = Math.max(maxLen, i - map.get(sum - k));
    }
    map.putIfAbsent(sum, i);    // Store first occurrence only
}
```

---

## 🔁 Sliding Window Variations — Placement Checklist

| Problem | Condition | Window Change |
|---|---|---|
| **Longest Subarray Sum = K** (non-neg) ✅ | `sum > k` → shrink | Two pointer |
| **Longest Subarray Sum = K** (with neg) | Use prefix sum map | HashMap |
| **Smallest Subarray Sum ≥ K** | `sum >= k` → shrink & update | Two pointer |
| **Max Subarray of size K** | Fixed window of size K | Slide by 1 |
| **Longest Substring K distinct chars** | Distinct count > K → shrink | Two pointer |

---

## 📌 Key Takeaways (Revision Flashcard)

- 🟡 **Sliding Window** works only when shrinking is meaningful → needs non-negative nums
- 🟡 `start` only moves **forward** → O(N) total despite nested loop
- 🟡 **Expand** on every iteration, **shrink** only when sum exceeds K  
- 🟡 Store `maxLen` only when `sum == k` exactly
- 🟡 **Negative numbers?** → Switch to HashMap Prefix Sum O(N) space
- 🟡 Time: **O(N)** | Space: **O(1)**

---

*If this helped your prep, please **⬆️ upvote** — it keeps me posting! All the best for placements! 💪*
