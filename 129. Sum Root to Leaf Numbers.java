/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        return sumR(root, 0);
    }
    
    public int sumR(TreeNode node, int sum){
        if (node.left == null && node.right == null){
            return sum*10+node.val;
        }
        int val = 0;
        if (node.left != null){
            val += sumR(node.left, sum*10+node.val);//累加左子树每一条路径的值
        }
        if (node.right != null){
            val += sumR(node.right, sum*10+node.val);//累加右子树每一条路径的值
        }
        return val;
    }
}
