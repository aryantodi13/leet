class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> v = new HashSet<>();
        v.add('a');
        v.add('e');
        v.add('i');
        v.add('o');
        v.add('u');
        char[] ch = s.toCharArray();
        int i;
        int iC = 0;
        int maxCount;
        for(i = 0; i < k; i ++){
            if(v.contains(ch[i])) iC++;
        }
        if(iC == k) return iC;
        maxCount = iC;
        for(i = k; i < s.length(); i ++){
            if(v.contains(ch[i])) iC++;
            if(v.contains(ch[i - k])) iC--;
            maxCount = Math.max(iC, maxCount);
        }
        return maxCount;
    }
}