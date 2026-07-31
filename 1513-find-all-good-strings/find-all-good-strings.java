class Solution {
    int mod=1000000007;
    int pre[];
    long dp[][][][];
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        if(s1.equals(s2)){//dealing the equal case
            if(s1.indexOf(evil)!=-1)return 0;
            return 1;
        }
       
        pre=pre(evil);
       
        dp=new long[s1.length()][s2.length()][2][2];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                for(int k=0;k<dp[0][0].length;k++)Arrays.fill(dp[i][j][k],-1);
            }
        }
        return (int)(dfs(evil,s1,s2,0,0,1,1));
    }
    
    public long dfs(String evil,String s1,String s2,int i,int j,int state1,int state2){
        if(j==evil.length())return 0;
        if(i==s1.length())return 1;
        
        if(dp[i][j][state1][state2]!=-1)return dp[i][j][state1][state2];
        
        long res=0;
        char small=s1.charAt(i);
        char big=s2.charAt(i);
        
        for(int x=0;x<26;x++){
            char c=(char)(x+'a');
            int news1=state1;
            int news2=state2;
            
            if(state1==1&&state2==0){
                if(c<small)continue;
                if(c!=small)news1=0;
            }
            else if(state1==0&&state2==1){
                if(c>big)continue;
                if(c!=big)news2=0;
            }
            else if(state1==1&&state2==1){
                if(c<small||c>big)continue;
                if(c!=small)news1=0;
                if(c!=big)news2=0;
            }
            else{//0 0
                
            }
            
            
            //kmp part
            int evinIndex=j;
            if(c==evil.charAt(evinIndex)){
                evinIndex++;
            }else{
                if(evinIndex==0){
                    
                }else{
                    while(evinIndex!=0&&evil.charAt(evinIndex)!=c)evinIndex=pre[evinIndex-1];
                    if(c==evil.charAt(evinIndex))evinIndex++;
                }
            }
            //////////////////////////
            
            res+=dfs(evil,s1,s2,i+1,evinIndex,news1,news2);
            res%=mod;
        }
        dp[i][j][state1][state2]=res;
        return res;
    }
    
    public int[] pre(String p){
        int pre[]=new int[p.length()];
        int l=0,r=1;
        while(r<p.length()){
            if(p.charAt(l)==p.charAt(r)){
                pre[r]=l+1;
                l++;r++;
            }else{
                if(l==0)r++;
                else l=pre[l-1];
            }
        }
        return pre;
    }
}