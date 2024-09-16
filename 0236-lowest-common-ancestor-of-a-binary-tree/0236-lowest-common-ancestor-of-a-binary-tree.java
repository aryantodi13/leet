/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return calc(root, p, q);
    }
    public TreeNode calc(TreeNode root, TreeNode p, TreeNode q){
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode left = null, right = null;
        if(root.left != null) left = calc(root.left, p, q);
        if(root.right != null) right = calc(root.right, p, q);
        if(left != null && right != null) return root;
        if(left != null ) return left;
        if(right != null ) return right;
        return null;
    }

}