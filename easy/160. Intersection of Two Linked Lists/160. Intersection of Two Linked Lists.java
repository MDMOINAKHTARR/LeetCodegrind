/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA= getListLength(headA);
        int lenB= getListLength(headB);

        while(lenA>lenB){
            lenA--;
            headA=headA.next;
        }

        while(lenB>lenA){
            lenB--;
            headB=headB.next;
        }

        while(headA !=headB){
            headA=headA.next;
            headB=headB.next;
        }
return headA;

    }
 private int getListLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
    
}
