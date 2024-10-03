class Solution {
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        char ch[] = s.toCharArray();
        if(s.length() > t.length()) return false;
        else if(s.length() == t.length()) return s.equals(t);
        for(char ch2 : t.toCharArray()){
            if(sp == s.length()) return true;
            if(ch[sp] == ch2) sp++;
        }
        return sp == s.length();
    }
}