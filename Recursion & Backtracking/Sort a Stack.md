# 🧠 Intuition
We want to **sort a stack using recursion only** (no extra data structures).

Think of it like:
👉 Remove all elements → then insert them back in **sorted order**

Key idea:
- Recursively **empty the stack**
- While inserting back, place each element in its **correct position**

This is similar to **insertion sort**, but done using recursion.

---

# 🚀 Approach
## Step 1: Sort the stack
- Pop top element
- Recursively sort remaining stack
- Insert the popped element in sorted position

## Step 2: Insert in sorted order (`sortRemaining`)
- If stack is empty OR correct position found → push value
- Else:
  - Pop top
  - Recursively find correct position
  - Push back popped element

---

# 🔁 How It Works (Dry Run)
Stack: `[3, 1, 4, 2]` (top = 2)

### Step 1: Break down

sortStack([3,1,4,2])
→ pop 2
→ sortStack([3,1,4])
→ pop 4
→ sortStack([3,1])
→ pop 1
→ sortStack([3])
→ pop 3
→ sortStack([])


---

### Step 2: Rebuild in sorted order

Insert 3 → `[3]`  
Insert 1 → `[1,3]`  
Insert 4 → `[1,3,4]`  
Insert 2 → `[1,2,3,4]`

---

# ⏱ Complexity

- **Time complexity:**  
  $$O(n^2)$$  
  - Each insertion takes O(n)
  - Done for n elements

- **Space complexity:**  
  $$O(n)$$  
  - Recursive call stack

---

# 💻 Code
```java
import java.util.*;
import java.io.*;

public class Solution {

    static void sortRemaining(Stack<Integer> stack, int val) {

        // Correct position found
        if (stack.isEmpty() || stack.peek() <= val) {
            stack.push(val);
            return;
        }

        int temp = stack.pop();

        sortRemaining(stack, val);

        stack.push(temp);
    }

    public static void sortStack(Stack<Integer> stack) {

        if (stack.isEmpty()) return;

        int val = stack.pop();

        sortStack(stack);

        sortRemaining(stack, val);
    }
}
