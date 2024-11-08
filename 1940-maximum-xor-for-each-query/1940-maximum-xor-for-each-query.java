class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int maxVal = (int) Math.pow(2, maximumBit) - 1;
        int contVal = 0;
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            contVal = contVal ^ nums[i];
            ans[nums.length - 1 - i] = contVal ^ maxVal;
        }
        return ans;
    }
}