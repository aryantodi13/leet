int minBitFlips(int start, int goal) {
    int j = start ^ goal;
    int count = 0;
    while(j > 0){
        count = count + j % 2;
        j = j / 2;
    }
    return count;
}