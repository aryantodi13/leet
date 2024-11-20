int takeCharacters(char* s, int k) {
    int ac = 0;
    int bc = 0;
    int cc = 0;
    int i;
    for(i = 0; s[i] != '\0';  i ++){
        if(s[i] == 'a') ac++;
        else if (s[i] == 'b') bc++;
        else cc++;
    }
    if(ac < k || bc < k || cc < k) return -1;
    int left = 0;
    int right = 0;
    int ak = ac - k;
    int bk = bc - k;
    int ck = cc - k;
    ac = 0;bc = 0;cc = 0;
    int max = 0;
    while(true){
        if(s[right]== 'a')ac++;
        else if (s[right] == 'b') bc++;
        else cc++;
        right++;
        if(ac > ak || bc > bk || cc > ck) {
            while(left <= right){
                if(s[left] == 'a') ac --;
                else if(s[left] == 'b') bc --;
                else cc --;
                left ++;
                if(ac <= ak && bc <= bk && cc <= ck) break;
            }
        }
        else{
            max = max > (right - left) ? max : right - left;
        }
        if(right == i) break;
    }
    return i - max;
}