class Solution {
    public int titleToNumber(String columnTitle) {
        int l = columnTitle.length();
        int pow = 1;
        int ans = 0;
        
        
        for (int i = l - 1; i >= 0; i--) {
            char letter = columnTitle.charAt(i);
            int ascii = (int) letter;
            int val = ascii - 64;
            ans += val * pow;
            pow *= 26;
        }
        
        
        return ans;
    }
}