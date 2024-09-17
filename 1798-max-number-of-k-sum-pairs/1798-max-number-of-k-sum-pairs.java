class Solution {
         public int maxOperations(int[] nums, int k) {
        int count = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int num = nums[i];
            if(num >= k) continue;
            if(mp.containsKey(num) && mp.get(num) == 1){
                mp.remove(num);
                count++;
            }
            else if(mp.containsKey(num)){
                mp.put(num, mp.get(num) - 1);
                count++;
            }
            else{
                if(mp.containsKey(k - num)){
                    mp.put(k - num, mp.get(k - num) + 1);
                }
                else {
                    mp.put(k - num, 1);
                }
            }
        }
        return count;
    }

}