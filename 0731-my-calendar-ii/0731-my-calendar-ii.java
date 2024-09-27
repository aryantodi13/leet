
    class MyCalendarTwo {
            List<int[]> ol;
            List<int[]> nol;
            public MyCalendarTwo() {
                ol = new ArrayList<>();
                nol = new ArrayList<>();
            }
            public boolean book(int start, int end) {
                for(int i = 0; i < ol.size(); i ++){
                    if(start >= ol.get(i)[1] || end <= ol.get(i)[0]) continue;
                    if(start >= ol.get(i)[0] || end <= ol.get(i)[1]) return false;
                    if(start < ol.get(i)[0] && end > ol.get(i)[1]) return false;
                }
                for(int i = 0; i < nol.size(); i ++){
                    if(start >= nol.get(i)[1] || end <= nol.get(i)[0]) continue;
                    if(start >= nol.get(i)[0] && end <= nol.get(i)[1]){
                        ol.add(new int[]{start, end});
                        return true;
                    }
                    if(start >= nol.get(i)[0]){
                        ol.add(new int[]{start, nol.get(i)[1]});
                        start = nol.get(i)[1];
                    }
                    else if(end <= nol.get(i)[1]){
                        ol.add(new int[]{ nol.get(i)[0], end});
                        end = nol.get(i)[0];
                    }
                    if(start < nol.get(i)[0] && end > nol.get(i)[1]){
                        ol.add(new int[]{nol.get(i)[0], nol.get(i)[1]});
                    }
                }
                nol.add(new int[]{start, end});
                return true;
            }
    }



/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */