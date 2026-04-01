import java.util.ArrayList;

public class Solution {

    static boolean ifPossible(ArrayList<Integer> boards, int mid, int k){

        int count = 1;
        int sum = 0;
        for(int i = 0; i < boards.size(); i++){
            if(sum + boards.get(i) > mid){
                sum = boards.get(i);
                count++;
            }
            else{
                sum += boards.get(i);
            }
        }

        return count <= k;

    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k){
        //    Write your code here.
        int start = boards.get(0);
        int end = 0;

        for(int board : boards){
            start = Math.max(start, board);
            end += board;
        }

        int ans = end;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(ifPossible(boards, mid, k)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return ans;
    }
}
