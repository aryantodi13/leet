class Solution {
  
    public int minSubarray(int[] nums, int p) {
            int sum = 0;
            for(int num : nums) sum = (sum + num) % p;
            int tgt_rem = sum % p;
            if(tgt_rem == 0) return 0;
            HashMap<Integer, Integer> remToInd = new HashMap<>();
            remToInd.put(0, -1);
            int res = nums.length;
            int curr= 0;
            for(int i = 0; i < nums.length; i ++){
                curr += nums[i];
                curr %= p;
                int prefix = (curr - tgt_rem + p) % p;
                if(remToInd.containsKey(prefix)){
                    res = Math.min(i - remToInd.get(prefix), res);
                }
                remToInd.put(curr, i);
            }
            if(res == nums.length) return -1;
            return res;
    }


}