class MyCalendar {
    int[] startTimes;
    int[] endTimes;
    int index = 0;
    int minStartTime = Integer.MAX_VALUE;
    int maxEndTime = Integer.MIN_VALUE;

    public MyCalendar() {
        startTimes = new int[1000];
        endTimes = new int[1000];
    }
    
    public boolean book(int start, int end) {
        if(index == 0){
            startTimes[index] = start;
            minStartTime = start;
            endTimes[index++] = end;
            maxEndTime = end;
            return true;
        }
        else{
            if(end <= minStartTime){
                startTimes[index] = start;
                endTimes[index++] = end;
                minStartTime = start;
                return true;
            }
            else if(start >= maxEndTime){
                startTimes[index] = start;
                endTimes[index++] = end;
                maxEndTime = end;
                return true;
            }
            else if(index == 1) return false;
            else{
                for(int i = 0; i < index; i ++){
                    //System.out.println("(" + start + "," + end + ")->("+startTimes[i] + "," + endTimes[i] + ")");

                    if(start == startTimes[i] || end == endTimes[i]) return false;
                    else if(start >= endTimes[i]) continue;
                    else if (end <= startTimes[i]) continue;
                    else if (start > startTimes[i] || end < endTimes[i]) return false;
                    else if(start < startTimes[i] && end > endTimes[i]) return false;
                }
                startTimes[index] = start;
                endTimes[index++] = end;
                minStartTime = Math.min(minStartTime, start);
                maxEndTime = Math.max(maxEndTime, end);
                return true;
            }
        }
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */