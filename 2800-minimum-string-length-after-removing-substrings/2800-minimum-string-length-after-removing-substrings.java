class Solution {
    public int minLength(String s) {
        while(true){
            int i = s.indexOf("AB");
            if(i == -1) i = s.indexOf("CD");
            if(i == -1) return s.length();
            else{
                if (i == 0) s = s.substring(2, s.length());
                else if(i == s.length() - 2) s = s.substring(0, s.length() - 2);
                else s = s.substring(0, i)+ s.substring(i + 2, s.length());
            }
            if(s.length() == 0) break;
        }
        return s.length();
    }
}