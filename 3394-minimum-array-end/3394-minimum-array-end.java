class Solution {
    public long minEnd(int n, int x) {
        int v = n - 1;
        long ans = 0;
        long mp = 1;
        while(v != 0){
            int xRem = x % 2;
            int vRem = v % 2;
            x = x/2;
            if(xRem == 0){
                ans = vRem * mp + ans;
                mp *= 2;
                v /= 2;
            }
            else{
                ans = xRem *mp + ans;
                mp *= 2;
            }
        }
        //System.out.println(x);
        while(x != 0){
            int xRem = x % 2;
            ans = xRem * mp + ans;
            mp *= 2;
            x /= 2;
        }
        //System.out.println(ans);

        return ans;
    }
}