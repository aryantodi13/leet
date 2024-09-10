class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s)) return true;
        if(s.length() == 1) return false;
        boolean ans;
        Map<String, Boolean> map = new HashMap<>();
        ans = dfs(s, wordDict, map);
        return ans;
    }
    public boolean dfs(String s, List<String> wordDict, Map<String, Boolean> map){
        if(s.length() == 0) return true;
        if(map.containsKey(s)) return map.get(s);
        //System.out.println(s);
        for(int i = 1; i <= s.length(); i ++){
            if(wordDict.contains(s.substring(0, i)) && dfs(s.substring(i), wordDict, map)) {
                map.put(s.substring(i), true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}