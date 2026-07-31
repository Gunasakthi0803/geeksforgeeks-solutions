class Solution {
    public String reformatDate(String date) {
        String a[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String d="";
        for(int i=date.length()-4;i<date.length();i++){
            d=d+date.charAt(i);
        }
        d=d+"-";
        String mon=date.substring(date.length()-8,date.length()-5);
        for(int i=0;i<a.length;i++){
            if(mon.equals(a[i])){
                if(i<9){
                    d=d+"0"+(i+1)+"-";
                }
                else{
                    d=d+(i+1)+"-";
                }
            }
        }
        String t=""+date.charAt(0)+date.charAt(1);
        if((int)t.charAt(1)>=48 && (int)t.charAt(1)<=57){
            d=d+t;
        }
        else{
            d=d+"0"+date.charAt(0);
        }
        return d;
    }
}