class Solution {
            public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> unique = new HashSet<>();
        Set<String> nonUnique = new HashSet<>();
        String[] word1 = s1.split(" ");
        String[] word2 = s2.split(" ");
        for(String s : word1){
            if(unique.contains(s)){
                unique.remove(s);
                nonUnique.add(s);
            }
            else if (!nonUnique.contains(s)){
                unique.add(s);
            }
        }
        for(String s : word2){
            if(unique.contains(s)){
                unique.remove(s);
                nonUnique.add(s);
            }
            else if (!nonUnique.contains(s)){
                unique.add(s);
            }
        }
        String[] ans = new String[unique.size()];
        ans = unique.toArray(ans);
        return ans;
    }


}