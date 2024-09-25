class Solution {
 
    class PrefixTree{
            int count;
            PrefixTree[] children;
            public PrefixTree(){
                count = 0;
                children = new PrefixTree[26];
            }
            public int getCount(){
                return count;
            }
            public void increment(){
                count++;
            }
            public PrefixTree getChild(char n){
                if(children[122 - n] == null) children[122 - n] = new PrefixTree();
                return children[122 - n];
            }
    }
    public int[] sumPrefixScores(String[] words) {
            int[] ans = new int[words.length];
            PrefixTree p = new PrefixTree();
            for(String str : words){
                PrefixTree temp = p;
                for(char ch : str.toCharArray()){
                    temp = temp.getChild(ch);
                    temp.increment();
                    //System.out.println(ch + " " + temp.getCount());
                }
            }
            int ind = 0;
            for(String str : words){
                int count = 0;
                PrefixTree temp = p;
                for(char ch : str.toCharArray()){
                    temp = temp.getChild(ch);
                    count += temp.getCount();
                }
                ans[ind++] = count;
            }
            return ans;
    }

}