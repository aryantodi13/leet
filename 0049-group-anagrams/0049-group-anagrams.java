class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String s : strs){
            char[] ch = new char[26];
            for(char c : s.toCharArray()){
                ch[122 - c]++;
            }
            StringBuilder str = new StringBuilder();
            for(char c : ch) str.append(c);
            if(mp.containsKey(str.toString())){
                List<String> sl = mp.get(str.toString());
                sl.add(s);
                mp.put(str.toString(), sl);
            }
            else{
                List<String> sl = new ArrayList<>();
                sl.add(s);
                mp.put(str.toString(), sl);
            }
        }
        return new ArrayList<>(mp.values());
    }


}