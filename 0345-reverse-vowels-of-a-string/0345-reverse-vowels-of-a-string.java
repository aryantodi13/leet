class Solution {

    public String reverseVowels(String s) {
            Set<Character> v = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            Stack<Character> q = new Stack<>();
            StringBuilder ans = new StringBuilder();
            for(char ch : s.toCharArray()){
                if(v.contains(ch)) q.add(ch);
            }
            for(int i = 0; i < s.length(); i ++){
                char ch = s.charAt(i);
                if(v.contains(ch)){
                    char tch = q.pop();
                    ans.append(tch);
                }
                else{
                    ans.append(ch);
                }
            }
            return ans.toString();
    }


}