// Leet Code
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder ans = new StringBuilder();
        int count = 0; // depth

        for (int i = 0; i < s.length(); i++) {
            // If we find a closing bracket, decrease depth first
            if (s.charAt(i) == ')') count--;

            // Append character if we are inside an inner layer
            if (count != 0) ans.append(s.charAt(i));

            // If we find an opening bracket, increase depth after appending logic
            if (s.charAt(i) == '(') count++;
        }

        return ans.toString();
    }
}
