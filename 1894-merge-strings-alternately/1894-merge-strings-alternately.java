class Solution {
        public String mergeAlternately(String word1, String word2) {
        String s = "";
        int len;
        int i = 0;
        if(word1.length() < word2.length()) len = word1.length();
        else len = word2.length();
        for(i = 0; i < len; i ++){
            s +="" + word1.charAt(i) + word2.charAt(i);
        }
        if(i < word1.length()){
            return s.concat(word1.substring(len));
        }
        else if (i < word2.length()) {
            return s.concat(word2.substring(len));
        }
        return s;
    }

}