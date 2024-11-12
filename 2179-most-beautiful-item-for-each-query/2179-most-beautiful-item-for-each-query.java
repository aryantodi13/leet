class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        int[] q2 = queries.clone();
        Arrays.sort(items, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        Arrays.sort(q2);
        HashMap<Integer, Integer> mp = new HashMap<>();
        int index = 0;
        int max = 0;
        for(int i : q2){
            while(index < items.length - 1 && items[index][0] <= i) {
                max = max > items[index][1] ? max : items[index][1];
                index++;
            }
            if( index == 0 && items[0][0] > i ) mp.put( i, 0 );
            else if ( index == items.length - 1 && items[index][0] <= i ){
                max = max > items[index][1] ? max : items[index][1];
                mp.put(i, max);
            }
            else{
                mp.put(i, max);
            }
        }
        // for(int i = 0; i < queries.length; i ++){
        //     while(index < items.length && items[index][0] <= q2[i])index++;
        //     if(index == 0 && items[0][0] > q2[i]) mp.put(q2[i], 0);
        //     else if(index == 0){ 
        //         mp.put(q2[i], items[0][1]);
        //         max = ans[i];
        //     }
        //     else if (index == items.length - 1 && items[index][0] <= q2[i]){
        //         mp.put(q2[i], max);
        //         ans[i] = max;
        //     }
        //     else{
        //         max = max > items[index - 1][1] ? max : items[index - 1][1];
        //         mp.put(q2[i], max);
        //     }
        // }
        for(int i = 0; i < queries.length; i ++){
            ans[i] = mp.get(queries[i]);
        }
        return ans;
    }
}