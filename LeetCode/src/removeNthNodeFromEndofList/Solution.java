package removeNthNodeFromEndofList;
/**
 * 题目：
Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.

Follow up:
Could you do this in one pass?

思路：考虑到遍历一次完成，则可以开辟一个相同的链表指针，然后让一个链表先走n步，后一个链表才开始走，
	  则当前一个链表走到尽头时，另一个链表落在需要remove的Node上，进而进行后续remove操作；
 * @author yifei
 *
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head==null||head.next==null) {
			return null;
		}
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1.next!=null) {
        	if (n==0) {
				p2 = p2.next;
			}
			if (n!=0) {
				n--;
			}
			p1=p1.next;	
		}
        if (n!=0) {//情况为：链表长度过短，n不为0时已经遍历完，说明需要remove的Node为head节点
			head = head.next;
		}else {
	        p2.next=p2.next.next;
		}
        return head;
    }
    public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l1 = new Solution().removeNthFromEnd(l1, 2);
		while (l1!=null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}