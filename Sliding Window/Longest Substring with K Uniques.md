# 🧠 Intuition
We need the **longest substring with exactly `k` distinct characters**.

Brute force would check all substrings → \(O(n^2)\), which is inefficient.

Instead, we use the **sliding window technique**:
- Expand the window using `right`
- Shrink the window using `left` when constraints break

Key idea:
- Maintain a **window with at most `k` distinct characters**
- When it exceeds `k`, shrink it
- When it equals `k`, update the answer

A **HashMap** helps track the frequency of characters in the current window.

---

# 🚀 Approach
1. Initialize:
   - `left = 0`, `right = 0`
   - `map` → stores character frequency
   - `ans = -1` (default if no valid substring exists)

2. Expand the window:
   - Add `s[right]` to the map

3. If `map.size() > k`:
   - Shrink window from the left
   - Decrease frequency
   - Remove character if its count becomes 0

4. If `map.size() == k`:
   - Update `ans = max(ans, window size)`

5. Move `right` forward and repeat

---

# ⏱ Complexity

- **Time complexity:**  
  $$O(n)$$  
  Each character is processed at most twice (once by `right`, once by `left`).

- **Space complexity:**  
  $$O(k)$$  
  At most `k` distinct characters in the map.

---

# 💻 Code
```java
class Solution {
    public int longestKSubstr(String s, int k) {
        int left = 0;
        int right = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int ans = -1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            // Shrink window if distinct chars exceed k
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            
            // Update answer when exactly k distinct characters
            if (map.size() == k) {
                ans = Math.max(ans, right - left + 1);
            }
            
            right++;
        }
        
        return ans;
    }
}
