# 🧠 Intuition
A **leader** in an array is an element that is **greater than or equal to all elements to its right**.  
The **rightmost element** is always a leader because there are no elements after it.

Instead of checking every element with all elements on its right (which would take \(O(n^2)\)), we can optimize the process by **traversing the array from right to left**.

While traversing:
- Keep track of the **maximum element seen so far from the right**.
- If the current element is **greater than or equal to this maximum**, it is a leader.
- Update the maximum and store the element.

Since we traverse from right to left, the leaders are collected **in reverse order**, so we reverse the result at the end.

---

# 🚀 Approach
1. Initialize:
   - `currGreater` to track the **maximum element from the right**.
   - An `ArrayList` to store the leaders.

2. Traverse the array from **right to left**.

3. For each element:
   - If `arr[i] >= currGreater`
     - Add it to the result list.
     - Update `currGreater`.

4. Reverse the result list to restore the **original order**.

5. Return the list of leaders.

---

# ⏱ Complexity

- **Time complexity:**  
  $$O(n)$$  
  We traverse the array once and reverse the list once.

- **Space complexity:**  
  $$O(k)$$  
  Where \(k\) is the number of leaders stored in the result list.

---

# 💻 Code
```java
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        
        int currGreater = 0;
        
        for(int i = n - 1; i >= 0; i--){
            if(arr[i] >= currGreater){
                ans.add(arr[i]);
                currGreater = arr[i];
            }
        }

        Collections.reverse(ans);
        return ans;
    }
}
