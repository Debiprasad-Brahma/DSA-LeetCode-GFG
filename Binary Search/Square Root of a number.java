import java.util.* ;
import java.io.*; 

public class Solution {

	public static int sqrtN(long N) {

		if(N == 0 || N == 1) return (int) N;

		long start = 1;
		long end = N / 2;

		long ans = 1;

		while(start <= end){
			long mid = start + (end - start) / 2;

			if(Math.pow(mid, 2) == N){
				ans = mid;
				break;
			}

			if(mid * mid < N){
				ans = mid;
				start = mid + 1;
			}
			else{
				end = mid - 1;
			}
		}

		return (int) ans;
	}
}
