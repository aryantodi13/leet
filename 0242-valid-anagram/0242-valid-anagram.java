class Solution {
    
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> h = new HashMap<>();
        char[] ch = new char[26];
        char[] ch2 = new char[26];
        for(char c : s.toCharArray()){
            ch[122 - (int) c]++;
        }
        for(char c : t.toCharArray()){
            ch2[122 - (int) c]++;
        }
        for(int i = 0; i < ch.length; i ++){
            if(ch[i] != ch2[i]) return false;
        }
        return true;
    }


}