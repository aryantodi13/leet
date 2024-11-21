int countUnguarded(int m, int n, int** guards, int guardsSize, int* guardsColSize, int** walls, int wallsSize, int* wallsColSize) {
    char map[m][n];
    for(int i = 0; i < m; i ++){
        for(int j = 0; j < n; j ++){
            map[i][j] = '.';
        }
    }
    for(int i = 0; i < guardsSize; i ++){
        map[guards[i][0]][guards[i][1]] = 'g';
    }
    for(int i = 0;i < wallsSize; i ++){
        map[walls[i][0]][walls[i][1]] = 'w';
    }
    bool gFound = false;
    bool wFound = false;
    for(int i = 0; i < m; i ++){
        gFound = false;
        wFound = false;
        for(int j = 0;j < n; j ++){
            if(map[i][j] == 'w') {wFound = true; gFound = false;}
            else if (map[i][j] == 'g'){ gFound = true; wFound = false;}
            else if (wFound) continue;
            else if(gFound) map[i][j] = 'f';
        }
        gFound = false;
        wFound = false;
        for(int j = n - 1;j >= 0; j --){
            if(map[i][j] == 'w') {wFound = true; gFound = false;}
            else if (map[i][j] == 'g'){ gFound = true; wFound = false;}
            else if (wFound) continue;
            else if(gFound) map[i][j] = 'f';
        }
    }
    for(int i = 0; i < n; i ++){
        wFound = false;
        gFound = false;
        for(int j = 0;j < m; j ++){
            if(map[j][i] == 'w') {wFound = true; gFound = false;}
            else if (map[j][i] == 'g'){ gFound = true; wFound = false;}
            else if (wFound) continue;
            else if(gFound) map[j][i] = 'f';
        }
        wFound = false;
        gFound = false;
        for(int j = m - 1;j >= 0; j --){
            if(map[j][i] == 'w') {wFound = true; gFound = false;}
            else if (map[j][i] == 'g'){ gFound = true; wFound = false;}
            else if (wFound) continue;
            else if(gFound) map[j][i] = 'f';
        }
    }
    int count = 0;
    for(int i = 0; i < m; i ++){
        for(int j = 0;j < n; j ++){
            //printf("%c ", map[i][j]);
            if(map[i][j] == '.') count++;
        }
        //printf("\n");
    }
    return count;

}