class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character,Integer>map = new HashMap<>();
        int i=0;
        for(char ch : s.toCharArray()){
            if(!map.containsKey(ch)){
                map.put(ch,i);
            }
            i++;
        }

        int cnt=0;

        HashMap<String, Boolean>map2 = new HashMap<>();

        for(String w : words){
            if(map2.containsKey(w)){
                if(map2.get(w)){
                    cnt++;
                }
                continue;
            }
            map2.put(w, false);
            if(map.containsKey(w.charAt(0)) && poss(s.substring(map.get(w.charAt(0))), w)){
                map2.put(w, true);
                cnt++;
            }
            
        }
        return cnt;
    }

    public boolean poss(String a, String b){
        int i=0;
        int j=0;
        while(i<a.length()){
            if(a.charAt(i)==b.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }

            if(j==b.length())return true;
        }
        return false;
    }
}