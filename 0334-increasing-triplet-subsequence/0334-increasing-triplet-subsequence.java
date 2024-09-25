class Solution {

    public boolean increasingTriplet(int[] nums) {
            int l1 = nums[0];
            int l2 = -1;
            for(int i = 1;i < nums.length; i ++){
                if(l2 == -1 && nums[i] > l1){
                    l2 = nums[i];
                }
                else if(l2 != -1 && nums[i] > l2){
                    return true;
                }
                else if(nums[i] > l1){
                    l2 = nums[i];
                }
                else{
                    l1 = nums[i];
                }
            }
            return false;
    }


}