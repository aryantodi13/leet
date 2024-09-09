class Solution {
     public int numSquares(int n){
        if(n < 4) return n;
        ArrayList<Integer> h = new ArrayList<>();
        for(int i = 1; i < n;i ++){
            if(i * i <= n) h.add(i*i);
            else break;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int mc = dpf(n, h, dp, h.size() - 1);
        System.out.println(mc);
        return mc;
    }
    public int dpf(int n, ArrayList<Integer> h, int[] dp, int index){
        if(h.size() == 1) return n;
        if(dp[n] != -1) return dp[n];
        if(h.get(index) > n) {
            while (h.get(index) > n){
                index --;
            }
            return dpf(n, h, dp, index);
        }
        else{
            if(n % h.get(index) == 0){ return dp[n] = n/h.get(index);}
            int take = n / h.get(index) + dpf(n % h.get(index), h, dp, index);
            int notake = dpf(n, h, dp, index - 1);
            return dp[n] = Math.min(take, notake);
        }
    }
}