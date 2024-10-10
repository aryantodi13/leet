class Solution {
    public int maxWidthRamp(int[] nums) {
                    //Preprocessing
        int[] maxRight = new int[nums.length];
        int max = nums[nums.length - 1];;
        for(int i = nums.length - 1; i >= 0; i --){
            max = Math.max(max, nums[i]);
            maxRight[i] = max;
        }
        int count = 0;
        int lp = 0;
        int rp = 1;
        while(rp != nums.length){
            if(maxRight[rp] >= nums[lp]){
                count = Math.max(count, rp - lp);
                rp++;
            }
            else lp++;
        }
        return count;
        }
}