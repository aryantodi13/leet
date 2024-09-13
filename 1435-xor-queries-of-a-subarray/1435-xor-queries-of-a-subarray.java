class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] ans = new int[queries.length];
        int[] prefix = new int[arr.length + 1];
        for(int i = 0; i < arr.length; i ++){
            if(i == 0) prefix[i] = arr[i];
            else prefix[i] = arr[i] ^ prefix[i-1];
        }
        for(int i = 0; i < queries.length; i++ ){
            int leftIndex = queries[i][0];
            int rightIndex = queries[i][1];
            if(leftIndex == rightIndex) ans[i] = arr[leftIndex];
            else if(rightIndex - leftIndex == 1) ans[i] = arr[leftIndex] ^ arr[rightIndex];
            else if (leftIndex == 0) ans[i] = prefix[rightIndex];
            else ans[i] = prefix[leftIndex - 1] ^ prefix[rightIndex];
        }
        return ans;
    }

}