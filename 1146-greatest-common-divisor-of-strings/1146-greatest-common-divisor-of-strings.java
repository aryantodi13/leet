class Solution {
    
    public String gcdOfStrings(String str1, String str2) {
        String shorter;
        if(str1.length() < str2.length()) shorter = str1;
        else shorter = str2;
        String ans = "";
        for(int i = shorter.length(); i >= 1; i--){
            String sub = shorter.substring(0,i);
            if(isDivisible(str1, sub) && isDivisible(str2, sub)) {
                ans = sub;
                break;
            }
        }
        return ans;
    }
    boolean isDivisible(String str1, String str2){
        if(str1.length() % str2.length() != 0) return false;
        System.out.println(str1 + " " + str2);
        int j = 0;
        for(int i = 0; i < str1.length(); i ++){
            if(j == str2.length()) j = 0;
            if(str1.charAt(i) == str2.charAt(j++)) continue;
            else return false;
        }
        if(j == str2.length()) return true;
        return false;
    }

}