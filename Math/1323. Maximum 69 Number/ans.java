class Solution {
    public int maximum69Number (int num) {
        StringBuilder s1 = new StringBuilder(Integer.toString(num));
        int[] digits = new int[s1.length()];
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) == '6'){
                s1.setCharAt(i, '9');
                break;
            }    
        } 
        return Integer.parseInt(s1.toString());
    }
}
