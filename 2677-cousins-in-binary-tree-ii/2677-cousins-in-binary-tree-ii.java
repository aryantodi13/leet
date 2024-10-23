/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> depSums = new ArrayList<>();
    int index = 0;
    Solution(){
        depSums.add(0);
        depSums.add(0);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        calculateSums(root, 0, depSums);
        return fn(root, 0);
    }
    public TreeNode fn(TreeNode root, int depth){
        int num = depth + 1 < depSums.size() ? depSums.get(depth + 1) : 0;
        System.out.println(num);
        // Get sum of children
        int chSum = 0;
        if(depth != 0){
        if(root.left != null && root.right != null) chSum = root.left.val + root.right.val;
        else if (root.left != null) chSum = root.left.val;
        else if (root.right != null) chSum = root.right.val;
        else return null;
        }
        else{ root.val = 0; }


        // Recurse
        if(root.left != null){
            root.left.val = num - chSum;
            fn(root.left, depth + 1);
        } 
        if(root.right != null){
            root.right.val = num - chSum;
             fn(root.right, depth + 1);
        }
        return root;
    }
    public void calculateSums(TreeNode root, int depth, List<Integer> l){
        if(depth == 0 || depth == 1) ;
        else{
            if(depth >= l.size()) l.add(0);
            int num = l.get(depth);
            num+= root.val;
            l.set(depth, num);
        }
        if(root.left == null && root.right == null) return;
        if(root.left != null) calculateSums(root.left, depth + 1, l);
        if(root.right != null) calculateSums(root.right, depth + 1, l);
    }
}