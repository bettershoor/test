package mergeTwoSortedLists;

/**
 * 题目：
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

思路：遍历两个链表，分别比较当前节点大小，然后拼接到新的链表中
 * @author yifei
 *
 */
public class Solution {	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resultlist = new ListNode(0);
        ListNode ptr = resultlist;
        while (l1!=null||l2!=null) {
			if (l1==null) {
				ptr.next = l2;
				break;
			}
			else if (l2==null) {
				ptr.next = l1;
				break;
			} else {
				ListNode temp = null;
				if (l1.val<l2.val) {
					ptr.next = l1;
//					temp = l1.next;
//					l1.next = null;
//					l1 = temp;
					l1 = l1.next;
					ptr = ptr.next;
				}else {
					ptr.next = l2;
//					temp = l2.next;
//					l2.next = null;
//					l2 = temp;
					l2 = l2.next;
					ptr = ptr.next;
				}
			}
		}
        return resultlist.next;
    }
    public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(3);
		ListNode node6 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		node4.next = node5;
		node5.next = node6;
		ListNode temp = new Solution().mergeTwoLists(node1, node4);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}