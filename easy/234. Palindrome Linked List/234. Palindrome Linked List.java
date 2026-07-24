/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast !=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //taaki right side chhoti rahe smaller rahe 
            if(fast!=null){
                slow=slow.next;
            }

            slow=reverselinkedlist(slow);
            fast=head;

            while(slow !=null){
                if(fast.val != slow.val){
                    return false;
                }

                fast=fast.next;
                slow=slow.next;
            }

            return true;
    }

    private ListNode reverselinkedlist(ListNode head){
    
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prevNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode nextNode = currNode.next; 
            currNode.next = prevNode;          
            prevNode = currNode;              
            currNode = nextNode;              
        }

        return prevNode;
    }
}
