class Solution {

    public int compress(char[] chars) {
            if(chars.length == 1) return 1;
            StringBuilder s = new StringBuilder();
            char ch = chars[0];
            int count = 1;
            for(int i = 1; i < chars.length; i ++){
                if(chars[i] == ch){
                    count++;
                }
                else{
                    s.append(ch);
                    if(count != 1) s.append(String.valueOf(count));
                    ch = chars[i];
                    count = 1;
                }
            }
        s.append(ch);
        if(count != 1) s.append(String.valueOf(count));
            int ind = 0;
            for(char ch2 : s.toString().toCharArray()){
                chars[ind++] = ch2;
            }
            return s.length();
    }


}