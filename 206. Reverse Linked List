/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // 迭代
    /*public ListNode reverseList(ListNode head) {
        ListNode reverseHeader = null;
        ListNode currentNode = head;// 记录当前操作的节点
        ListNode prevNode = null; // 记录上一个节点
        // 每次操作修改next的指向
        // 例:a->b->c 1 a.next = null; 2 b.next = a; 3 c.next = b;
        // prevNode:null --> a --> b  currentNode:a --> b --> c
        while (currentNode != null){
            ListNode nextNode = currentNode.next;// 记录操作节点的下一个节点
            if (nextNode == null){
                reverseHeader = currentNode;
            }
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }
        return reverseHeader;
    }*/
    
    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        //ListNode nextNode = head.next;
        ListNode reverseHead = reverseList(head.next);//reverseHead从最后一个节点返回
        
        head.next.next = head;// 反转连接
        head.next = null;//删除原来的连接
        //nextNode.next = head;// 反转连接
        
        return reverseHead;
    }
}
