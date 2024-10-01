class Solution {

    public boolean canArrange(int[] arr, int k) {
            List<Integer> l = new ArrayList<>();
            Map<Integer, Integer> mp = new HashMap<>();
            for(int i = 0; i < arr.length; i ++){
                int num = arr[i];
                if(num < 0) num = ((num % k) + k) % k;
                if(num % k == 0 && mp.get(0) != null) mp.remove(0);
                else if(num % k == 0) mp.put(0, 1);
                else if(mp.get(num % k) != null){
                    if(mp.get(num % k) == 1) mp.remove(num % k);
                    else mp.compute(num % k, (key, val) -> val - 1);
                }
                else{
                    mp.compute(k - (num % k), (key, v) -> v == null? 1 : v + 1);
                }
            }
            return mp.size() == 0;
    }


}