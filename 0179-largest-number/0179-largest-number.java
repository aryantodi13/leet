class Solution {
      
    public String largestNumber(int[] nums) {
        List<String> nstr = new ArrayList<>();
        StringBuilder f = new StringBuilder();
        boolean containsNonZero = false;
        for(int i : nums) {
            if(i != 0) containsNonZero = true;
            nstr.add(String.valueOf(i));
        }
        if(!containsNonZero) return "0";
        nstr.sort((x, y) -> { return Math.toIntExact(comp(x, y)); });
        for(int i = nstr.size() - 1; i >= 0; i --){
            f.append(nstr.get(i));
        }
        return f.toString();
    }
    public long comp(String x, String y){
        int lenx = x.length();
        int leny = y.length();
        int xint = Integer.parseInt(x);
        int yint = Integer.parseInt(y);
        long xFirst = (long) (Math.pow(10, leny) * xint + yint);
        long yFirst = (long) (Math.pow(10, lenx) * yint + xint);
        return xFirst - yFirst;
    }



}