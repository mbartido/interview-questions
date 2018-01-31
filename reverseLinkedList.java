// https://leetcode.com/problems/reverse-linked-list/description/
// Reverse a singly linked list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
   public ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode curr = head;
        
      while (curr != null){
         ListNode temp = curr.next;
         curr.next = prev;
         prev = curr;
         curr = temp;
      }
      return prev;
   }
}

class Solution2 {
   public ListNode reverseList(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode restOfList = reverseList(head.next);   // recursive portion
      // make sure next's pointer points to previous
      head.next.next = head;
      head.next = null;
      return restOfList;
   }
}