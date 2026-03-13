import java.util.*;
public class Solution {
    public static int getLongestZeroSumSubarrayLength(int []arr){
        // Write your code here.

        int ans = 0;
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];

            if(sum == 0)
            ans = i + 1;

            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }

        return ans;
    }
}
