class Solution {
    

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1 && flowerbed[0] == 0) return true;
            int count = 0;
            int start = -1;
            for(int i = 0; i < flowerbed.length; i ++){
                if(flowerbed[i] == 0) count++;
                else{
                    if(start == -1) n = n - count/2;
                    else n = n - (count - 1) / 2;
                    count = 0;
                    start = i;
                }
                //System.out.println(start);
            }
            if(start == -1) n = n - (count + 1)/2;
            else n = n - count/2;
            return n <= 0;
    }




}