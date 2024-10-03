class Solution {
    public void moveZeroes(int[] nums) {
        int ct = 0;
        for(int i = 0; i< nums.length; i ++){
            if(nums[i] == 0){ct++;continue;}
            else if(ct == 0) continue;
            nums[i-ct] = nums[i];
            nums[i] = 0;
        }
        //for(int i = 0; i < ct; i ++) nums[nums.length - i - 1] = 0;
    }
}