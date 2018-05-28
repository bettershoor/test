package addTwoNumbersInList;
/**
 * 题目：You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

		You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example:
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
思路：
1、将List中的各个整数先整合成一个数；然后两个数相加，最后将结果拆分加入到新的List中--------->错误：在整合成一个数的地方会有数据类型限制，无法满足所有可能的数

正解思路：将两个链表逐位取出相加，为空则取出0，注意进位carry

 * @author yifei
 *
 */
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
    	 val = x; 
     }
}
public class Solution {
/*   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode resList = new ListNode(-1);
       ListNode temp = resList;
	   long a1 = integrate(l1);
	   long a2 = integrate(l2);
	   long result = a1 + a2;
       while (result!=0) {
    	   ListNode newNode = new ListNode((int)result%10);
    	   temp.next = newNode;
           temp = temp.next;
    	   result = result/10;
       }
       return resList.next;
   }
   public Long integrate(ListNode l) {
	   String resStr = new String();
	   while (l!=null) {
		   resStr += String.valueOf(l.val);
		   l = l.next;
	   }
	   return Long.valueOf(resStr);
   }*/
	   public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       ListNode resList = new ListNode(-1);
	       ListNode head = resList;
	       int carry = 0;
	       while (l1!=null || l2!=null || carry!=0) {
	    	   int res = (l1==null?0:l1.val) + (l2==null?0:l2.val) + carry;
	    	   carry = res/10;
	    	   int modeVal = res%10;
	    	   head.next = new ListNode(modeVal);
	    	   head = head.next;
	    	   l1 = l1==null?l1:l1.next;
	    	   l2 = l2==null?l2:l2.next;
	       }
	       return resList.next;
	   }
}
