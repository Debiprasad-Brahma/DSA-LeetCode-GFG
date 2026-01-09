## 🥈 Find Second Largest Element in an Array

### Intuition  
To find the **second largest element**, we don’t need to sort the array.  
Sorting would increase the time complexity unnecessarily.

Instead, we can keep track of:
- The **largest** element seen so far
- The **second largest** element seen so far

As we scan the array once:
- If we find a new largest value, the old largest becomes the second largest.
- If the current value is smaller than the largest but bigger than the second largest, we update the second largest.

This ensures we always have the correct second largest value by the end.

---

### Approach  
1. Initialize two variables:
   - `largest = -1`
   - `secLargest = -1`
2. Traverse the array:
   - If `arr[i] > largest`:
     - Update `secLargest = largest`
     - Update `largest = arr[i]`
   - Else if `arr[i]` is between `largest` and `secLargest`:
     - Update `secLargest`
3. Return `secLargest`.

If no second largest element exists, the function correctly returns `-1`.

---

### Time & Space Complexity  
- **Time Complexity:** O(n)  
- **Space Complexity:** O(1)

---

### Code  
```java
class Solution {
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        int largest = -1;
        int secLargest = -1;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > largest) {
                secLargest = largest;
                largest = arr[i];
            } 
            else if (arr[i] > secLargest && arr[i] != largest) {
                secLargest = arr[i];
            }
        }
        return secLargest;
    }
}
