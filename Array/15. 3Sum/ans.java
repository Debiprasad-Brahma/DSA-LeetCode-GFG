// Leet Code
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(nums);

       for(int i=0; i<nums.length - 2; i++){
        if(i > 0 && nums[i] == nums[i-1]) continue;
        int val = nums[i];
        int left = i+1;
        int right = nums.length - 1;
        while(left < right){
        int total = val + nums[left] + nums[right];
            if(total == 0){
                ans.add(Arrays.asList(val, nums[left], nums[right]));
                while(left < right && nums[left] == nums[left+1]) left++;
                while(left < right && nums[right] == nums[right-1]) right--;
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
