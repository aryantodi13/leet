class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length == 1) return 1;
        int ans = 0;
        int max = -1;
        for(int i : nums) if(i > max) max = i;
        //System.out.println(max);
        int lenArr = 0;
        // Sliding window
        int left = 0;
        while(left < nums.length){
            if(nums[left] != max){
                left++;
                continue;
            }
            int right = left;
            while(right < nums.length && nums[right] == max) right++;
            if(right - left > lenArr) lenArr = right - left;
            left = right;
        }
        return lenArr;
    }

}