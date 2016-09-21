/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 // 解题思路：http://www.jianshu.com/p/ce7f035daf74
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode first = head;
        ListNode second = head;
        while (second != null && second.next != null){
            first = first.next;
            second = second.next.next;
            if (first == second){// 出现环！不一定是环的起始点，需要判断！
                ListNode p = head;
                ListNode q = second;
                while (p!=q){
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}
