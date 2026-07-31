class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];

        for(int i=0; i<s.length(); i++){
            lastIndex[s.charAt(i)-'a'] = i; 
        }

        boolean[] visited = new boolean[26];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            int c = s.charAt(i)-'a';
            if(visited[c]) continue;

            visited[c] = true;

            while(!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek()] > i){
                visited[stack.pop()] = false;
            }
            stack.push(c);
        }
        StringBuilder res = new StringBuilder();

        for(int l : stack){
            res.append((char)(l+'a'));
        }
        return res.toString();
    }
}