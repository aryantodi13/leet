class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int contVal = nums[0];
        int[] num2 = new int[nums.length];
        num2[0] = contVal;
        for(int i = 1; i < nums.length; i ++){
            contVal = contVal ^ nums[i];
            //System.out.println(i + " " + contVal);
            num2[i] = contVal;

        }
        int maxVal = (int) Math.pow(2, maximumBit) - 1;
        //System.out.println("Max val : " + maxVal);
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i ++){
            ans[nums.length - 1 -i] = num2[i] ^ maxVal;
        }
        return ans;
    }
}