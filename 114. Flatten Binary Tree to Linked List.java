/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }
        List<TreeNode> nodes = preorder(root);
        TreeNode p = root;
        for (int i=1; i<nodes.size(); i++){// 注意此处i的值从1开始！！！
            p.left = null;
            p.right = nodes.get(i);
            p = p.right;
        }
    }
    
    public List<TreeNode> preorder(TreeNode root){// 先序遍历
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (root == null){
            return nodes;
        }
        nodes.add(root);
        if (root.left != null){
            nodes.addAll(preorder(root.left));
        }
        if (root.right != null){
            nodes.addAll(preorder(root.right));
        }
        return nodes;
    }
    
    /*public List<TreeNode> inorder(TreeNode root){//中序遍历！！！
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (root == null){
            return nodes;
        }
        
        if (root.left != null){
            nodes.addAll(preorder(root.left));
        }
        
        nodes.add(root);
        
        if (root.right != null){
            nodes.addAll(preorder(root.right));
        }
        return nodes;
    }
    
    public List<TreeNode> preorder(TreeNode root){// 后序遍历！！
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if (root == null){
            return nodes;
        }
        if (root.left != null){
            nodes.addAll(preorder(root.left));
        }
        if (root.right != null){
            nodes.addAll(preorder(root.right));
        }
        nodes.add(root);
        return nodes;
    }*/
}
