# 🏆 Count of Matches in Tournament | Math Trick | O(1) Time

## Intuition
In a tournament where every match eliminates **exactly one team**, the total number of matches needed to determine a winner is always **(n - 1)**.  

Why?  
- Start with `n` teams.  
- Each match eliminates one team.  
- To end with 1 winner, we must eliminate `(n - 1)` teams.  
- Therefore, the total number of matches = `n - 1`.  

---

## Approach
1. Directly return `n - 1` since that represents the number of eliminated teams.  

---

## Complexity
- **Time Complexity:** **O(1)** → simple arithmetic.  
- **Space Complexity:** **O(1)** → no extra memory.  

---

## Code
```java
class Solution {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}
