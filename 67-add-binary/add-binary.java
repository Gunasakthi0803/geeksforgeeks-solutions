class Solution {
    public String addBinary(String a, String b) {
         String ans = "";
        int n = a.length() - 1, m = b.length() - 1;
        int carry = 0;

        while (n >= 0 || m >= 0 || carry == 1) {

            int digit1 = 0, digit2 = 0;
            if (n >= 0)
                digit1 = a.charAt(n--) - '0';
            if (m >= 0)
                digit2 = b.charAt(m--) - '0';

            int sum = digit1 + digit2 + carry;
            ans += (sum % 2) + "";
            carry = sum / 2;
        }

        char store[] = ans.toCharArray();
        int start = 0, end = ans.length() - 1;

        while (start < end) {
            
            char temp = store[start];
            store[start] = store[end];
            store[end] = temp;

            start++;
            end--;
        }

        return new String(store);
    }
}
       