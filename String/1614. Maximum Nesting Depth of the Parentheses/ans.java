// Leet Code
class Solution {
    public int maxDepth(String s) {
        int ans = 0;    // Maximum depth encountered
        int count = 0;  // Current depth

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++; // Entering a deeper level
            }
            else if (s.charAt(i) == ')') {
                count--; // Exiting a level
            }
            ans = Math.max(count, ans); // Update max depth if needed
        }

        return ans;
    }
}
