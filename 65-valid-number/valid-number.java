class Solution {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;

        s = s.trim();  // Remove leading/trailing spaces
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean digitAfterExp = true;  // assume true unless 'e' is seen

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Digit
            if (Character.isDigit(c)) {
                seenDigit = true;
                if (seenExp) digitAfterExp = true;
            }

            // Sign (+/-)
            else if (c == '+' || c == '-') {
                // Must be at the start or right after 'e'
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            }

            // Decimal point
            else if (c == '.') {
                // Cannot appear after 'e' or more than once
                if (seenDot || seenExp)
                    return false;
                seenDot = true;
            }

            // Exponent
            else if (c == 'e' || c == 'E') {
                if (seenExp || !seenDigit)
                    return false;
                seenExp = true;
                digitAfterExp = false;  // reset
            }

            // Invalid characters
            else {
                return false;
            }
        }

        return seenDigit && digitAfterExp;
    }
}
    
    