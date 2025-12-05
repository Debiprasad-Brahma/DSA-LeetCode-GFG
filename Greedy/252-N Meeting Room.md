## 🕒 Max Meetings in One Room | Greedy Scheduling by Finish Time

### 💡 Intuition  
This is the classic **Activity Selection Problem**:

> To schedule the maximum number of non-overlapping meetings,  
> **always pick the meeting that finishes earliest**.

Why?  
Because choosing the earliest-ending meeting leaves the maximum time window for future meetings.

---

### 🧠 Approach  
1. Create an index array so we can sort meetings without losing original order.
2. Sort the indices based on:
   - **Primary key:** end time (ascending)  
   - **Tie-breaker:** start time (ascending)
3. Select the first meeting (it ends earliest).
4. For each next meeting:
   - If its start time is strictly **greater** than the last selected meeting's end time → include it.
5. Count how many meetings you can select.

This greedy strategy ensures optimal scheduling.

---

### ⏱️ Complexity  
- **Time Complexity:** O(n log n) — due to sorting  
- **Space Complexity:** O(n) — index array  

---

### 💻 Code  
```java
import java.util.*;

class Solution {
    public int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        // index array
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        // sort indices by end time; tie-break by start time
        Arrays.sort(idx, (a, b) -> {
            int cmp = Integer.compare(end[a], end[b]);
            if (cmp != 0) return cmp;
            return Integer.compare(start[a], start[b]);
        });

        int count = 1;
        int lastEnd = end[idx[0]];

        // Strict > is used for typical "Max Meetings" logic
        for (int i = 1; i < n; i++) {
            int s = start[idx[i]];
            int e = end[idx[i]];
            if (s > lastEnd) {
                count++;
                lastEnd = e;
            }
        }
        return count;
    }
}
