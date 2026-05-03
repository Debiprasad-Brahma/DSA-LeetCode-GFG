# 🔥 Generate Binary Strings Without Consecutive 1s — Complete Guide

## 🧠 Intuition (Interview-Level)

We need to generate all binary strings of length `N` such that:
👉 **No two consecutive 1s are allowed**

---

### ❓ What does this really mean?

If N = 3:
Valid:
000
001
010
100
101

Invalid:
011 ❌
110 ❌
111 ❌

---

### 🔍 Key Observation

At every position:
- We can always place '0'
- We can place '1' only if previous character is NOT '1'

👉 This is a constraint-based decision problem

---

## 🔥 Core Idea

At every step:
Add '0' → always valid  
Add '1' → only if last != '1'

---

## 🚀 Approach (Step-by-Step)

1. Start with empty string
2. At each step:
   - Add '0' always
   - Add '1' only if last character != '1'
3. Stop when curr.length == N
4. Add to result

---


## 💻 Optimized Code

```java
import java.util.*;

public class Solution {

    static void solve(List<String> ans, String curr, int n){

        if(curr.length() == n){
            ans.add(curr);
            return;
        }

        solve(ans, curr + '0', n);

        if(curr.length() == 0 || curr.charAt(curr.length() - 1) != '1'){
            solve(ans, curr + '1', n);
        }
    }

    public static List<String> generateString(int N) {
        List<String> ans = new ArrayList<>();
        solve(ans, "", N);
        return ans;
    }
}
```

---

## ⏱ Complexity

Time: O(2^N)  
Space: O(N)

---

## 🔥 Key Insight

We avoid invalid strings during generation

---

## 🧩 Pattern

Backtracking + Constraint Pruning

---

## 🎯 Interview Tip

Say:
"We prevent consecutive 1s during recursion instead of filtering later"

---

## 🧠 Mental Model

Try → Check → Continue
