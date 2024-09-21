class Solution {
    
    public List<Integer> lexicalOrder(int n) {
        int count = 0;
        int first = 1;
        List<Integer> ans = new ArrayList<>();
        while(count < n){
            ans.add(first);
            count++;
            if(first * 10 <= n) first *= 10;
            else{
                if(first >= n) first = first / 10;
                first = first + 1;
                while(first % 10 == 0) first = first / 10;
            }
        }
        return ans;
    }


}