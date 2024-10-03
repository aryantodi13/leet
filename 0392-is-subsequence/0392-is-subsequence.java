class Solution {
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        if(s.length() > t.length()) return false;
        else if(s.length() == t.length()) return s.equals(t);
        for(int i = 0; i < t.length(); i ++){
            if(sp == s.length()) return true;
            if(s.charAt(sp) == t.charAt(i)) sp++;
        }
        return sp == s.length();
    }
}