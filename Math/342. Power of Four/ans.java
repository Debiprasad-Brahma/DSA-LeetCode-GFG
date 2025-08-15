// Leet Code
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0) return false;
        if(n == 1) return true;
        if(n % 4 == 0) return isPowerOfFour(n/4);
        return false;
    }
}

// GFG
class Solution {
    int isPowerOfFour(long n) {
      if(n==1) return 1;
      if(n==0) return 0;
      if(n % 4 == 0) return isPowerOfFour(n/4);
      return 0;
    }
}
