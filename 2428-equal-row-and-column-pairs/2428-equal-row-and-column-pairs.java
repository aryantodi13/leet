class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<String, Integer> rowMap = new HashMap<>();
        HashMap<String, Integer> colMap = new HashMap<>();
        for(int i = 0; i < grid.length; i ++){
            StringBuilder s = new StringBuilder();
            StringBuilder s2 = new StringBuilder();
            for(int j = 0; j < grid.length; j ++){
                s.append(grid[i][j]).append(".");
                s2.append(grid[j][i]).append(".");
            }
            if(rowMap.containsKey(s.toString())){
                rowMap.put(s.toString(), rowMap.get(s.toString()) + 1);
            }
            else{
                rowMap.put(s.toString(), 1);
            }
            if(colMap.containsKey(s2.toString())){
                colMap.put(s2.toString(), colMap.get(s2.toString()) + 1);
            }
            else{
                colMap.put(s2.toString(), 1);
            }
        }
        int sum = 0;
        for(String s : rowMap.keySet()){
            if(colMap.containsKey(s)){
                sum += rowMap.get(s) * colMap.get(s);
            }
        }
        return sum;
    }

}