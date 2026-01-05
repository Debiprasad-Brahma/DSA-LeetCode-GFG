## 📉 Next Smaller Element (to the Right) | Monotonic Stack Approach

### Intuition  
For each element in the array, we want to find the **next element to its right that is smaller** than it.  
If no such element exists, we return `-1` for that position.

A brute-force approach would compare every element with all elements to its right, but that would take **O(n²)** time.  
To optimize this, we use a **monotonic increasing stack**.

---

### Approach  
1. Traverse the array from left to right.
2. Use a stack to store **indices** of elements whose next smaller element hasn’t been found yet.
3. For each current element:
   - While the stack is not empty and the element at the top of the stack is **greater than the current element**:
     - Pop the index from the stack.
     - The current element is the **next smaller element** for that index.
4. Push the current index onto the stack.
5. After traversal:
   - Any indices still left in the stack do not have a next smaller element → assign `-1`.
6. Build the result list in the original order.

---

### Time & Space Complexity  
- **Time Complexity:** O(n)  
  Each element is pushed and popped at most once.
- **Space Complexity:** O(n)  
  Stack and map usage.

---

### Code  
```java
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;

        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int curr = arr[i];

            // Resolve next smaller for elements in stack
            while (!stk.isEmpty() && arr[stk.peek()] > curr) {
                int idx = stk.pop();
                map.put(idx, curr);
            }

            stk.push(i);
        }

        // Remaining elements have no next smaller
        while (!stk.isEmpty()) {
            map.put(stk.pop(), -1);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(map.get(i));
        }

        return res;
    }
}
