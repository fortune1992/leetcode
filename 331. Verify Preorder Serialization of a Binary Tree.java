/*
One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, 
we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
*/

public class Solution {
    //"9,3,4,#,#,1,#,#"出错的原因是因为9的右子树为空，最后应该添加一个"#"
    /*
    利用Stack的解法：
         可以在字符串里找"n##"这种结构（对应tree里两个children都是Null的叶节点），找到之后就把"n##"改写成"#"，
        也就是把找到的那个末端的子树想想成null，最后字符串变成"#"的就是valid，否则就invalid
        比如 A) 9 3 "4 # #" "1 # #" 2 # "6 # #" ---> 9 3 # # 2 # # ---> 9 "3 # #" "2 # #" ---> 9 # # ---> "9 # #" ---> "#"
             B) 9 3 "4 # #" "1 # #" ---> 9 3 # # ---> 9 "3 # #" ---> 9 # (没有"n##"结构了，return false)
    */
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0){
            return false;
        }
        String split[] = preorder.split(",");
        Stack<String> stack = new Stack<String>();
        for (int i=0; i<split.length; i++){
            String cur = split[i];
            while (cur.equals("#") && !stack.empty() && stack.peek().equals("#")) {//注意此处是while循环！
                stack.pop();
                if (stack.empty()){//出现这种情况直接返回false "#,#", "#,#,#"
                    return false;
                }
                stack.pop();
            }
            stack.push(cur);
        }
         return stack.size() == 1 && stack.peek().equals("#");
    }
    
   
    /*
    Some used stack. Some used the depth of a stack. Here I use a different perspective. In a binary tree, 
    if we consider null as leaves, then

        all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
        all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
        
    Suppose we try to build this tree. During building, we record the difference between out degree and in degree 
    diff = outdegree - indegree. When the next node comes, we then decrease diff by 1, because the node provides an in degree. 
    If the node is not null, we increase diff by 2, because it provides two out degrees. If a serialization is correct, 
    diff should never be negative and diff will be zero when finished.
    */
   /* public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0){
            return false;
        }
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node:nodes){
            // diff = outdegree - indegree
            if (--diff < 0){//增加一个节点的入度加1
                return false;
            }
            if (!node.equals("#")){// 增加的是非空节点，出度加2.哪怕是左右子树均为空，出度也为2,如节点4（"#,#"）
                diff+=2;
            }
        }
        return diff == 0;
    }*/
}
