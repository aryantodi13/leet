class Solution {
    public String getPermutation(int n, int k){
        ArrayList<Integer> nums = new ArrayList<>();
        int[] facts = new int[n + 1];
        facts[0] = 0;
        for(int i = 1; i <= n; i ++){
            nums.add(i);
            if(i == 1) facts[i] = 1;
            else facts[i] = (i) * facts[i - 1];
        }
        String ans = dfs(nums, k - 1, facts);
        System.out.println(ans);
        return ans;
    }
    public String dfs(ArrayList<Integer> nums, int k, int[] facts){
        if(nums.size() == 1) return String.valueOf(nums.get(0));
        int q = k / facts[nums.size() - 1];
        int r = k % facts[nums.size() - 1];
        String val = String.valueOf(nums.get(q));
        nums.remove(q);
        return val + dfs(nums, r, facts);
    }
}