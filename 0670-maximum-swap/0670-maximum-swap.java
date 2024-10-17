class Solution {
    public int maximumSwap(int num) {
        // Approach 2
        // Get max value to the right of array and swap if the value at particular point is less that the max to the right of it.
        char[] ch = String.valueOf(num).toCharArray();
        HashMap<Character, Integer> mp = new HashMap<>();
        char lToR[] = new char[ch.length];
        mp.put(ch[ch.length - 1], ch.length - 1);
        lToR[ch.length - 1] = ch[ch.length - 1];
        for(int i = ch.length - 2; i >= 0; i --){
            if(ch[i] > lToR[i + 1]){
                lToR[i] = ch[i];
                mp.put(ch[i], i);
            }
            else{
                lToR[i] = lToR[i + 1];
            }
        }
        for(int i = 0; i < ch.length; i ++){
            if(ch[i] < lToR[i]){
                char temp = ch[i]; 
                ch[i] = lToR[i];
                ch[mp.get(lToR[i])] = temp;
                break;
            }
        }
        return Integer.valueOf(new String(ch));
    }

}