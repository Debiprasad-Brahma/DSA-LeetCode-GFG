public class Solution {
    public static int NthRoot(int n, int m) {
        if(n > m) return -1;
        
        int start = 1;
        int end = m;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(Math.pow(mid, n) == m) return mid;

            if(Math.pow(mid, n) > m){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
