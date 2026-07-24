/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while (true) {

            ListNode kthNode = getKthNode(groupPrev, k);

            if (kthNode == null) {
                break;
            }

            ListNode groupNext = kthNode.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode nextNode = curr.next;

                curr.next = prev;

                prev = curr;
                curr = nextNode;
            }

        
            ListNode oldGroupStart = groupPrev.next;

           
            groupPrev.next = kthNode;

            groupPrev = oldGroupStart;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode current, int k) {

        while (current != null && k > 0) {
            current = current.next;
            k--;
        }

        return current;
    }
}
