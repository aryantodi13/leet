class Solution {
    public boolean primeSubOperation(int[] nums) {
        if(nums.length == 1) return true;
        int[] primes = new int[1001];
        int primeTemp = 0;
        ArrayList<Integer> pri = new ArrayList<>();
        for(int i = 2; i < 1001; i ++){
            int count = 0;
            //System.out.println((int) Math.sqrt(i));
            for(int j = 2; j <= (int) Math.sqrt(i); j ++){
                count = 1;
                if(i % j == 0) break;
                count = 0;
            }
            if(count == 0){
                primeTemp = i;
                pri.add(i);
            }
            primes[i] = primeTemp;
        }
        //System.out.println(pri.size());
        //for(int i = 0; i < primes.length; i ++) System.out.println(primes[i]);
        //System.out.println(pri.get(pri.indexOf(primes[331])));

        for(int i = 0; i < nums.length; i ++){
            int num = nums[i];
            if(i == 0){
                int clPrime = primes[num];
                if(num == 2) continue;
                clPrime = num == clPrime ? pri.get(pri.indexOf(clPrime) - 1) : clPrime;
                nums[i] = num - clPrime;
                //System.out.println(nums[i]);
                continue;
            }
            if(i == nums.length - 1) return nums[i] > nums[i - 1];
            int prev = nums[i - 1];
            if(num <= prev) return false;
            else if(num - prev == 1 || num - prev == 2 ) continue;
            int clPrime = primes[num - prev];
            clPrime = num - prev == clPrime ? pri.get(pri.indexOf(clPrime) - 1) : clPrime;
            nums[i] = num - clPrime;
            //System.out.println(nums[i]);
            //System.out.println(clPrime);
        }
        return false;
    }
}