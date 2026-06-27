import java.util.Stack;

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

    public ListNode reverseList(ListNode head) {

        // Create a stack to store node values
        Stack<Integer> valueStack = new Stack<>();

        // Traverse the linked list and push all values into the stack
        while (head != null) {
            valueStack.push(head.val);
            head = head.next;
        }

        // Create a dummy node
        ListNode reversedList = new ListNode(-1);

        // Pointer to build the reversed list
        ListNode ptr = reversedList;

        // Pop values from the stack and create new nodes
        while (!valueStack.isEmpty()) {
            ptr.next = new ListNode(valueStack.pop());
            ptr = ptr.next;
        }

        // Return the actual head (skip dummy node)
        return reversedList.next;
    }
}
