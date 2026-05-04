# 🔥 Next Smaller Element | O(N) Monotonic Stack | Beats Brute Force O(N²) | Placement Must-Know

---

## 💡 Intuition

The naive approach checks every element to the right for each element — **O(N²)**. 
The key insight: **we don't need to go back**. 

> If we process left → right and maintain a **decreasing stack**, whenever a new element is *smaller* than the stack's top, that new element is exactly the **Next Smaller Element** for the top.

Think of it like standing in a queue — you only care about the **next person shorter than you**, and a stack lets you resolve that the moment they arrive.

---

## 🧠 Approach — Monotonic Stack (Decreasing)

We maintain a stack of **indices** (not values), so we can fill results at the right positions.

### Step-by-step:
1. Initialize `res[]` with `-1` (default: no smaller element found).
2. Traverse the array left to right.
3. For each element `arr[i]`:
   - While stack is **not empty** AND `arr[i] < arr[stack.top()]`:
     - Pop the top index → `arr[i]` is its Next Smaller Element → `res[top] = arr[i]`
   - Push current index `i` onto the stack.
4. Remaining indices in stack → no smaller element → stay `-1`.

---

## 📊 Dry Run

```
arr = [4, 8, 5, 2, 25]
```

| i | arr[i] | Stack (indices) | Action |
|---|--------|-----------------|--------|
| 0 | 4      | [0]             | Push 0 |
| 1 | 8      | [0, 1]          | Push 1 |
| 2 | 5      | [0, 2]          | 5 < 8 → res[1]=5, pop 1; 5 > 4 → Push 2 |
| 3 | 2      | [3]             | 2 < 5 → res[2]=2; 2 < 4 → res[0]=2; Push 3 |
| 4 | 25     | [3, 4]          | Push 4 |

**Result:** `[2, 5, 2, -1, -1]` ✅

---

## ✅ Code (Java)

```java
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);          // Default: no smaller element

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < n; i++) {
            int num = arr[i];
            // Pop all elements for which current element is the next smaller
            while (!stk.isEmpty() && num < arr[stk.peek()]) {
                res[stk.pop()] = num;
            }
            stk.push(i);               // Store index, not value
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int num : res) ans.add(num);

        return ans;
    }
}
```

---

## ⏱ Complexity Analysis

| | Complexity | Reason |
|---|---|---|
| **Time** | O(N) | Each element is pushed and popped at most once |
| **Space** | O(N) | Stack + result array |

> ⚠️ **Why not O(N²)?** Every index enters and exits the stack **exactly once** → total operations = 2N → **O(N)**

---

## 🔁 Variations to Know for Placements

| Problem | Change |
|---|---|
| **Next Greater Element** | Flip condition: `num > arr[stk.peek()]` |
| **Previous Smaller Element** | Traverse **right to left** |
| **Next Smaller or Equal** | Use `num <= arr[stk.peek()]` |
| **Circular Array** | Traverse `2N` with `i % n` indexing |

---

## 📌 Key Takeaways (Revision Flashcard)

- 🟡 **Monotonic Stack** = Stack maintaining increasing or decreasing order
- 🟡 **Store indices** in stack, not values — gives positional control
- 🟡 **Fill result on POP**, not on push
- 🟡 **Remaining stack elements** → result stays `-1` (no answer)
- 🟡 Time: **O(N)** | Space: **O(N)**

---

*If this helped you, please **⬆️ upvote** — it keeps me motivated to post more clean solutions!* 🙌
