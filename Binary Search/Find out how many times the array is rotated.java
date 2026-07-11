public class Solution { 
    public static int findKRotation(int []arr){ 
        int start = 0;
        int end = arr.length - 1;
        if(arr[start] <= arr[end]) return 0;

        while(start < end){
            int mid = start + (end - start) / 2;

            if(arr[mid] > arr[end]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return start;
    }
        
}
