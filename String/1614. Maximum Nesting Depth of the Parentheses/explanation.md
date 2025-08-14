# Maximum Nesting Depth of the Parentheses

## Question
A string is a valid parentheses string (VPS) if it meets one of the following conditions:  
- It is an empty string `""`, or a single lowercase character.  
- It can be written as `AB` (A concatenated with B), where A and B are VPS.  
- It can be written as `(A)`, where A is a VPS.  

Given a VPS represented as a string `s`, return the **maximum nesting depth** of parentheses in `s`.  
The nesting depth is the maximum number of nested parentheses.

---

## Example
**Input**
s = "(1+(2*3)+((8)/4))+1"

**Output**

**Explanation**
- The deepest nesting occurs in `"((8)/4)"`, which is at depth **3**.  
- Steps:
  1. `(1+(` → depth 2  
  2. `(1+(2*3)+((` → depth 3 (**max reached here**)  
  3. Closing parentheses reduce the depth back down.

---

## Intuition
Every `(` increases the current depth, and every `)` decreases it.  
We track the current depth during traversal and update the maximum depth whenever we go deeper.

---

## Approach
1. Initialize:
   - `count` → current depth
   - `ans` → maximum depth found so far
2. Loop through each character in `s`:
   - If `'('` → increment `count`
   - If `')'` → decrement `count`
   - Update `ans` with `max(ans, count)`
3. Return `ans`

---

## Complexity
- **Time Complexity:** `O(n)` — single pass through the string  
- **Space Complexity:** `O(1)` — constant extra space

---

## Code
```java
class Solution {
    public int maxDepth(String s) {
        int ans = 0;    // Maximum depth encountered
        int count = 0;  // Current depth

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++; // Entering a deeper level
            }
            else if (s.charAt(i) == ')') {
                count--; // Exiting a level
            }
            ans = Math.max(count, ans); // Update max depth if needed
        }

        return ans;
    }
}
