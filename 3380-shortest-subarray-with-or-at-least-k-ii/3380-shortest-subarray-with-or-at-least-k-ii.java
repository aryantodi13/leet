class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int bits[] = new int[32];
        int left = 0;
        int right = 0;
        int minLen = -1;
        int len = 0;
        while(right < nums.length){
            if(nums[right] >= k) return 1;

            int temp = nums[right];
            int bit = 0;
            while(temp != 0){
                bits[bit++] += temp % 2;
                temp /= 2;
            }
            if(calcNum(bits) >= k){
                minLen = minLen == -1 || minLen > (right - left + 1) ? (right - left + 1) : minLen;
                //System.out.println("Minlen:" + minLen + ":Left:" + left + ":Right:" + right);
                while(true){
                temp = nums[left];
                bit = 0;
                while(temp!= 0){
                    bits[bit++] -= temp % 2;
                    temp /= 2;
                }
                if(calcNum(bits) >= k){
                    minLen = minLen == -1 || minLen > (right - left) ? (right - left) : minLen;
                    left ++;
                }
                else {
                    left++;
                    break;
                }
                }
                
            }
            right++;
        }
        return minLen;       
    }
    int calcNum(int[] bits){
        int mp = 1;
        int num = 0;
        for(int i = 0; i< bits.length; i ++){
            //System.out.print(bits[i] + " ");
            num += bits[i] >0 ? 1 * mp: 0;
            mp *= 2;
        }
        //System.out.println();
        //System.out.println(num);
        return num;
    }
}