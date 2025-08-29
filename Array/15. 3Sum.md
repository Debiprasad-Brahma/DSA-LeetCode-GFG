# 3Sum Problem — Java Solution

## Intuition
The goal is to find all unique triplets in the array that sum to zero.  
A naive triple loop approach would be **O(n³)**, which is too slow.  
By **sorting the array** and using the **two-pointer technique**, we can reduce the complexity to **O(n²)** while also making it easier to avoid duplicates.

---

## Approach
1. **Sort the array** to enable two-pointer traversal and simplify duplicate handling.
2. Loop through the array with index `i`:
   - If `nums[i]` is the same as the previous value, skip it (to avoid duplicate triplets).
3. For each `i`:
   - Set `left = i + 1` and `right = nums.length - 1`.
   - While `left < right`:
     - Calculate `total = nums[i] + nums[left] + nums[right]`.
     - If `total == 0`:
       - Store the triplet.
       - Skip duplicate `left` and `right` values.
       - Move both pointers inward.
     - If `total < 0`: increment `left` (increase sum).
     - If `total > 0`: decrement `right` (decrease sum).
4. Return the list of unique triplets.

---

## Code
```java

// Leet Code
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(nums);

       for (int i = 0; i < nums.length - 2; i++) {
           if (i > 0 && nums[i] == nums[i - 1]) continue;
           int val = nums[i];
           int left = i + 1;
           int right = nums.length - 1;

           while (left < right) {
               int total = val + nums[left] + nums[right];
               if (total == 0) {
                   ans.add(Arrays.asList(val, nums[left], nums[right]));
                   while (left < right && nums[left] == nums[left + 1]) left++;
                   while (left < right && nums[right] == nums[right - 1]) right--;
                   left++;
                   right--;
               } else if (total < 0) {
                   left++;
               } else {
                   right--;
               }
           }
       }

       return ans;
    }
}




// GFG
class Solution {
    public static ArrayList<ArrayList<Integer>> triplets(int[] arr) {
        // code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<arr.length-2; i++){
            if (i > 0 && arr[i] == arr[i - 1]) continue; // Skip duplicate first element
            
            int val = arr[i];
            int left = i+1;
            int right = arr.length - 1;
            
            while(left < right){
                int total = val + arr[left] + arr[right];
                if(total == 0){
                    
                    ArrayList<Integer> triplet = new ArrayList<>();
                    triplet.add(val);
                    triplet.add(arr[left]);
                    triplet.add(arr[right]);
                    ans.add(triplet);
                    
                    while(left<right && arr[left] == arr[left+1]) left++;
                    while(left<right && arr[right] == arr[right-1]) right--;
                    
                    left++;
                    right--;
                }
                else if(total < 0) left++;
                else right--;
            }
        }
        return ans;
    }
}
