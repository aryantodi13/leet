class Solution {
    public int maxOperations(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] >= k) continue;
            int num = nums[i];
            if(mp.containsKey(num)){
                int temp = mp.get(num);
                if(temp == 1){
                    mp.remove(num);
                }
                else{
                    mp.put(num, temp - 1);
                }
                count++;
            }
            else if(mp.containsKey(k - num)){
                mp.put(k - num, mp.get(k - num) + 1);
            }
            else{
                mp.put(k - num, 1);
            }
        }
        return count;
    }

}