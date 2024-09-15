class Solution {
        public int findTheLongestSubstring(String s) {
        HashMap<Character, Integer> vals = new HashMap<>();
        vals.put('a', 1);
        vals.put('e', 2);
        vals.put('i', 4);
        vals.put('o', 8);
        vals.put('u', 16);

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int maxLen = 0;
        int len = 0;
        int cnt = 0;

        for(int i = 0; i < s.length(); i ++){
            char ch = s.charAt(i);
            if(vals.containsKey(ch)){
                cnt ^= vals.get(ch);
            }
            else{
                cnt ^= 0;
            }
            if(mp.containsKey(cnt)){
                len = i - mp.get(cnt);
                maxLen = Math.max(len, maxLen);
            }
            else{
                mp.put(cnt, i);
            }
        }
        return maxLen;
    }

}