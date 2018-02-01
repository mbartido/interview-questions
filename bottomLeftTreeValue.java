// https://leetcode.com/problems/find-bottom-left-tree-value/submissions/1
// Given a binary tree, find the leftmost value in the 
// last row of the tree.
// 
/* 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
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
class Solution {
   public int findBottomLeftValue(TreeNode root) {
      // Algorithm is like bfs
      Queue<TreeNode> queue = new LinkedList<TreeNode>();  // making queue
      TreeNode head = root;
      queue.add(head);    // add the head to queue
      while (!queue.isEmpty()) {
         head = queue.poll();   // remove first element of list
         // order is right left to obtain left most value of bottom of tree
         // order is left to right to obtain right most value of bottom of tree
         if (head.right != null) queue.add(head.right);
         if (head.left != null) queue.add(head.left);
      }
      return head.val;
   }
}
