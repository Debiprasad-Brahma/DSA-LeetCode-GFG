## 🚉 Minimum Platforms | Greedy Timeline Sweep (Arrival–Departure Sorting)

### 💡 Intuition  
To find the **minimum number of platforms** required so that no train has to wait,  
we only need to check **how many trains are at the station at the same time**.

When arrivals and departures overlap, we need more platforms.

This becomes a classic **sweep-line** problem:
- Sort all arrival times  
- Sort all departure times  
- Walk through both arrays with two pointers  
- If a train arrives before the next one departs → need a new platform  
- Else → a train leaves, freeing a platform

---

### 🧠 Approach  
1. Sort arrival array `arr[]`
2. Sort departure array `dep[]`
3. Use two pointers:
   - `i` → arrival index  
   - `j` → departure index  
4. Maintain:
   - `count` → current platforms needed  
   - `maxCount` → maximum platforms ever needed  
5. While `i < n`:
   - If `arr[i] <= dep[j]`  
     → a train arrives before previous one leaves  
     → increase `count`  
     → increment `i`
   - Else  
     → a train has departed  
     → reduce `count`  
     → increment `j`
6. Track max platforms using `maxCount`.

---

### ⏱️ Complexity  
- **Time Complexity:** O(n log n) — sorting arrivals & departures  
- **Space Complexity:** O(1) — only counters and pointers used

---

### 💻 Code  
```java
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        int count = 0, maxCount = 0;

        while (i < n) {

            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }
}
