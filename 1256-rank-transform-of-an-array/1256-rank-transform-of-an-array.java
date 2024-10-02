class Solution {
 
   
    public int[] arrayRankTransform(int[] arr) {
            int[] k = Arrays.copyOf(arr, arr.length);
            Arrays.sort(k);
            ArrayList<Integer> l = new ArrayList<>();
            HashMap<Integer, Integer> mp = new HashMap<>();
            for(int i = 0; i < k.length; i ++){
                int num = k[i];
                int tempI = i;
                mp.compute(num, (key, v) -> v == null ? mp.size() : v);
            }
            for(int i = 0; i< arr.length; i ++){
                k[i] = mp.get(arr[i]) + 1;
            }
            return k;
    }




}