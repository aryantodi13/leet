char* longestCommonPrefix(char** strs, int strsSize) {
    char* prefix = strs[0];
    for(int i = 1; i < strsSize; i ++){
        char* str = strs[i];
        int j;
        for (j = 0; j < strlen(str); j ++){
            if(prefix[j] == '\0') {
                break;
            }
            else if(prefix[j] != str[j]){
                prefix[j] = '\0';
                break;
            }
        }
        if(j == strlen(str) && prefix[j] != '\0'){
            prefix[j] = '\0';
        }
    }
    return prefix;
}