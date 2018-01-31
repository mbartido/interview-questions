// https://leetcode.com/problems/add-two-numbers/description/
// You are given two non-empty linked lists representing two 
// non-negative integers. The digits are stored in reverse
// order and each of their nodes contain a single digit. Add
// the two numbers and return it as a linked list.
// You may assume the two numbers do not contain any leading 
// zero, except the number 0 itself.
// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class add2LinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;                 // list 1
        ListNode q = l2;                 // list 2
        ListNode retList = new ListNode(0);  
        ListNode curr = retList;         // for keeping track of adding list
        int carry = 0;                   // carry variable
        while (p != null || q != null){
            // checks to see if position in list is now null
            int val1 = (p != null)? p.val: 0;
            int val2 = (q != null)? q.val: 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;            // carry is sum divided by 10
            curr.next = new ListNode(sum % 10);  // next position is sum mod 10
            curr = curr.next;            // advance curr to next position
            // Advance both lists to the next position
            p = p.next;
            q = q.next;
        }
        if (carry > 0){
            curr.next = new ListNode(carry);
        }
        return retList.next;
	}
}