## 🐄 Aggressive Cows | Binary Search on Maximum Minimum Distance

### 💡 Intuition  
You are given stall positions and must place `k` cows such that the **minimum distance between any two cows is as large as possible**.

Key observations:
- If you can place all cows with a minimum distance `d`, then you can also place them with any **smaller distance**.
- If you cannot place cows with distance `d`, then any **larger distance** is also impossible.

This **monotonic property** makes the problem perfect for **binary search on the answer**.

---

### 🧠 Approach  

#### Step 1: Sort the stalls  
Sorting allows greedy placement of cows from left to right.

#### Step 2: Feasibility Check — `canPlaceCows`
Given a candidate distance `dist`:
- Place the first cow in the first stall
- Place each next cow in the earliest stall that is at least `dist` away from the previous one
- Count how many cows can be placed
- If count ≥ `k`, placement is possible

#### Step 3: Binary Search
- `low = 1` (minimum possible distance)
- `high = stalls[n-1] - stalls[0]` (maximum possible distance)
- If a distance is feasible, try larger distances
- Otherwise, try smaller distances

---

### ⏱️ Complexity  
- **Time Complexity:** O(n log D)  
  - `n` = number of stalls  
  - `D` = distance range (`max - min`)
- **Space Complexity:** O(1)

---

### 💻 Code  
```java
class Solution {

    private boolean canPlaceCows(int[] stalls, int cows, int dist) {
        int n = stalls.length;
        int cnt = 1;          // place first cow
        int prev = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - prev >= dist) {
                prev = stalls[i];
                cnt++;
            }
        }
        return cnt >= cows;
    }

    public int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);
        int n = stalls.length;

        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int minDist = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                minDist = mid;      // possible, try bigger distance
                low = mid + 1;
            } else {
                high = mid - 1;     // reduce distance
            }
        }
        return minDist;
    }
}
