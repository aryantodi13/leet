class Solution {
    public String reverseWords(String s) {
        String[] s3 = s.split(" ");
        StringBuilder s2 = new StringBuilder();
        for(int i = s3.length - 1; i >= 0; i --){
            String temp = s3[i].replaceAll("\\s", "");
            if(temp.length() > 0) s2.append(temp).append(' ');
        }
        return s2.toString().trim();
    }
}