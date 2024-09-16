class Solution {
              public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() == 2) return calcMin(timePoints.get(0), timePoints.get(1));
        timePoints.sort(String::compareTo);
        int li = 0;
        int ri = 1;
        int minTime = calcMin(timePoints.get(0), timePoints.get(timePoints.size() - 1));
        while(ri < timePoints.size() ){
            minTime = Math.min(minTime, calcMin(timePoints.get(li), timePoints.get(ri)));
            li++;
            ri++;
        }
        return minTime;
    }
    public int calcMin(String a, String b){
        if(a.equals(b)) return 0;
        int lh = Integer.valueOf(a.split(":")[0]);
        int lm = Integer.valueOf(a.split(":")[1]);
        int rh = Integer.valueOf(b.split(":")[0]);
        int rm = Integer.valueOf(b.split(":")[1]);

        int diff = Math.abs((lh - rh) * 60 + (lm - rm));
        diff = Math.min(diff, 1440 - diff);
        return diff;
    }

}