# 🧠 Intuition
We want to **reverse a stack using recursion only** (no extra data structure).

Key idea:
- If we **pop everything**, the stack becomes empty
- While returning from recursion, we insert elements **at the bottom**

👉 This effectively reverses the order

So the strategy is:
1. Remove the **top element**
2. Recursively reverse the remaining stack
3. Insert the removed element **at the bottom**

---

# 🚀 Approach
## Step 1: Reverse the stack
- Pop top element
- Recursively reverse remaining stack
- Insert popped element at bottom

## Step 2: Insert at bottom
- If stack is empty → push element
- Otherwise:
  - Pop top
  - Recursively insert at bottom
  - Push back the popped element

---

# 🔁 How Recursion Works (Important)
For stack: `[1, 2, 3, 4]` (top = 4)

### reverseStack calls:

reverseStack([1,2,3,4])
→ pop 4
→ reverseStack([1,2,3])
→ pop 3
→ reverseStack([1,2])
→ pop 2
→ reverseStack([1])
→ pop 1
→ reverseStack([])

Now stack is empty.

---

### While returning:
- insertAtBottom(1) → [1]
- insertAtBottom(2) → [2,1]
- insertAtBottom(3) → [3,2,1]
- insertAtBottom(4) → [4,3,2,1]

👉 Stack reversed

---

# ⏱ Complexity

- **Time complexity:**  
  $$O(n^2)$$  
  - Each insertAtBottom takes O(n)
  - Called for each element

- **Space complexity:**  
  $$O(n)$$  
  - Recursive call stack

---

# 💻 Code
```java
import java.util.Stack;

public class Solution {
    
    static void insertAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();

        insertAtBottom(stack, value);

        stack.push(temp);
    }

    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int temp = stack.pop();

        reverseStack(stack);

        insertAtBottom(stack, temp);
    }
}
