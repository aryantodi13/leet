class Solution {
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        for(int i = 0; i < t.length(); i ++){
            if(sp == s.length()) return true;
            if(s.charAt(sp) == t.charAt(i)) sp++;
        }
        return sp == s.length();
    }
}