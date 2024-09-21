class Solution {
    
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = -1;
        for(int i : candies) if (i > max) max = i;
        List<Boolean> l = new ArrayList<>();
        for(int i : candies){
            if(i + extraCandies >= max) l.add(true);
            else l.add(false);
        }
        return l;
    }


}