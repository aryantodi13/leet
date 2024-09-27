class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int lp = 0;
        int rp = k;
        double firstAv = 0;
        double fas = 0;
        for(rp = 0; rp < k; rp++){
            fas += nums[rp];
        }
        firstAv = fas/k;
        while(rp < nums.length){
            fas -= nums[lp++];
            fas += nums[rp++];
            firstAv = Math.max(firstAv, fas/k);
        }
        return firstAv;
    }
}