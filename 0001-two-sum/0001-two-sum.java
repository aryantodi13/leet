class Solution {
    

    public int[] twoSum(int[] nums, int target) {
        if(nums.length == 2) return new int[]{0, 1};
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(mp.containsKey(nums[i])){
                return new int[]{mp.get(nums[i]), i};
            }
            mp.put(target - nums[i], i);
        }
        return null;
    }



}