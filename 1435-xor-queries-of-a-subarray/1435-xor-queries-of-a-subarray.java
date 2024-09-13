class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        for(int i = 0; i < queries.length; i ++){
            int leftIndex = queries[i][0];
            int rightIndex = queries[i][1];
            int xor = arr[leftIndex];
            for(int j = leftIndex + 1; j <= rightIndex; j ++){
                xor = xor ^ arr[j];
            }
            ans[i] = xor;
        }
        return ans;
    }

}