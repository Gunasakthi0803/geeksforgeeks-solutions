class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if(n<3)return false;
        boolean flag = false;
        for(int i=1;i<n;i++)
            {
                if((flag && arr[i]>arr[i-1]) || (arr[i]==arr[i-1]))return false;
                if(arr[i]<arr[i-1] && i==1)return false;
                if(arr[i]<arr[i-1]) flag = true;
            }
        return flag;
    }
}