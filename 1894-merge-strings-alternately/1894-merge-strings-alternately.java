class Solution {
    public String mergeAlternately(String word1, String word2) {
        String s = "";
        if(word1.length() == word2.length()){
            for(int i = 0; i < word2.length(); i ++){
                String s1 = String.valueOf(word1.charAt(i));
                String s2 = String.valueOf(word2.charAt(i));
                s = s + s1 + s2;
            }
            return s;
        }
        else if(word1.length() > word2.length()){
            for(int i = 0; i < word2.length(); i ++){
                String s1 = String.valueOf(word1.charAt(i));
                String s2 = String.valueOf(word2.charAt(i));
                s = s + s1 + s2;
            }
            s = s.concat(word1.substring(word2.length()));
            return s;
        }
        else{
            for(int i = 0; i < word1.length(); i ++){
                String s1 = String.valueOf(word1.charAt(i));
                String s2 = String.valueOf(word2.charAt(i));
                s = s + s1 + s2;
            }
            s = s.concat(word2.substring(word1.length()));
            return s;
        }
    }

}