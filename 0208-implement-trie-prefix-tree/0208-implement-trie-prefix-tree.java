class Trie {
    boolean ends;
    Trie[] children;
    public Trie() {
        ends = false;
        children = new Trie[26];
    }
    
    public void insert(String word) {
        Trie temp = this;
        for(int i = 0; i < word.length(); i ++){
            char ch = word.charAt(i);
            if(temp.children[122 - ch] == null){
                temp.children[122 - ch] = new Trie();
            }
            temp = temp.children[122 - ch];
            if(i == word.length() - 1) temp.ends = true;
        }
    }
    
    public boolean search(String word) {
        Trie temp = this;
        for(int i = 0; i < word.length(); i ++){
            char ch = word.charAt(i);
            if(temp.children[122 - ch] == null ) return false;
            temp = temp.children[122 - ch];
        }
        return temp.ends;
    }
    
    public boolean startsWith(String prefix) {
        Trie temp = this;
        for(int i = 0; i < prefix.length(); i ++){
            char ch = prefix.charAt(i);
            if(temp.children[122 - ch] == null) return false;
            temp = temp.children[122 - ch];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */