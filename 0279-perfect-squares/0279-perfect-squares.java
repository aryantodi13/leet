class Solution {
      public int numSquares(int n){
        if (n < 4) return n;
        ArrayList<Integer> s = new ArrayList<>();
        for(int i = 1; i < n; i ++){
            int temp = i * i;
            if(temp > n) break;
            s.add(i*i);
        }
        Integer[] s2 = new Integer[s.size()];
        s2 = s.toArray(s2);
        Integer[][] dp = new Integer[s2.length][n + 1];
        for(int i = 0; i < s2.length; i ++) Arrays.fill(dp[i], -1);
        int minCount = dpf(n, s2, s2.length - 1, dp);
        return minCount;
    }
    public int dpf(int n, Integer[] s, int i, Integer[][] dp){
        if (i == 0) return n;
        if(dp[i][n] != -1) return dp[i][n];
        if (n < s[i]){
            while(s[i] > n) i--;
            return dpf(n, s, i, dp);
        }
        if(n - s[i] == 0) return 1;
        else{
            int temp = n - s[i];
        }
        // Recursive cases
        // Take
        int cTake;
        if(n % s[i] == 0){
            cTake = n/s[i];
        }
        else {
            cTake = (Integer) n / s[i] + dpf(n % s[i], s, i - 1, dp);
        }
        int cNoTake = dpf(n, s, i - 1, dp);
        dp[i][n] = Math.min(cTake, cNoTake);
        return dp[i][n];
        // No Take
    }
}