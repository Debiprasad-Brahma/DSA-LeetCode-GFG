# 🔢 Maximum 69 Number (LeetCode 1323)

## 📌 Problem
You are given a positive integer that only contains digits `6` and `9`.  
You can **change at most one digit** (`6 → 9`) to maximize the number.  
Return the maximum number you can get.

---

## 📝 Example
**Input:**  
num = 9669

**Output:**  
9969


**Explanation:**  
- Changing the first `6` gives `9969` (maximum).  
- Changing any other `6` would result in smaller values.

---

## 💡 Intuition
- The number only contains `6`s and `9`s.  
- To maximize the number, we should **change the first `6` we encounter** into a `9`.  
- Only one change is allowed, so we stop after the first replacement.  

---

## 🔑 Solutions

### ✅ Approach 1: Using `StringBuilder`
```java
class Solution {
    public int maximum69Number (int num) {
        StringBuilder s = new StringBuilder(Integer.toString(num));
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6') {
                s.setCharAt(i, '9'); // change first '6' to '9'
                break; // only once
            }
        }
        
        return Integer.parseInt(s.toString());
    }
}
```
### ✅ Approach 2: Using `replaceFirst`
```java
class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        s = s.replaceFirst("6", "9"); // replace only first '6'
        return Integer.parseInt(s);
    }
}
```
### ✅ Approach 3: Using `Math-based (without String)`
```java
class Solution {
    public int maximum69Number (int num) {
        int place = -1; // position of first 6 from right
        int temp = num;
        int pos = 0;
        
        while (temp > 0) {
            if (temp % 10 == 6) {
                place = pos; // store last found '6'
            }
            temp /= 10;
            pos++;
        }
        
        if (place == -1) return num; // no '6' found
        
        return num + 3 * (int)Math.pow(10, place); // change 6 → 9
    }
}

```
# ⏱️ Complexity Analysis

## Approach 1 & 2 (String-based):

**Time Complexity: O(d) (where d = number of digits)**
**Space Complexity: O(d) (string conversion)**

## Approach 3 (Math-based):
**Time Complexity: O(d)**
**Space Complexity: O(1) (no extra space)**
