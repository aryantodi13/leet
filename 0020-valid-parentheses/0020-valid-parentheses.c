bool isValid(char* s) {
    
    int len = strlen(s);
    char stack[len + 1];
    char* head = stack;
    char* ptr = stack;
    int k = ptr == head;
    for(int i = 0; i < len; i++){
        char ch = s[i];
        switch(ch){
            case ']':
                if (*ptr != '['){
                    return false;
                }
                else{
                    *ptr-- = '\0';
                }
                break;
            case '}':
                if(*ptr != '{'){
                    return false;
                }
                else {
                    *ptr-- = '\0';
                }
                break;
            case ')':
                if(*ptr != '('){
                    return false;
                }
                else{
                    *ptr-- = '\0';
                }
                break;
            case '[':
            case '{':
            case '(':
                *++ptr = ch;
                break;
        }
    }
    printf("%d\n", ptr == head);
    return ptr == head;
}
