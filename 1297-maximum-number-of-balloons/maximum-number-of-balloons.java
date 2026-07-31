class Solution {
    public int maxNumberOfBalloons(String text) {
        int bc=0,ac=0,lc=0,oc=0,nc=0;
        for (char cc : text.toCharArray()) {
            switch (cc) {
                case 'b': bc++; break;
                case 'a': ac++; break;
                case 'l': lc++; break;
                case 'o': oc++; break;
                case 'n': nc++; break;
            }
        }
            return Math.min(bc,Math.min(ac,Math.min(nc,Math.min(lc/2,oc/2))));
    }
}