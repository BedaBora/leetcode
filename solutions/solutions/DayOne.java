package solutions;

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
 */

public class DayOne {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = result;
        int carry = 0;
        while(l1 != null || l2 !=null){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }

            if( l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum /10;
            sum %= 10;
            if(result == null){
                result = new ListNode(sum);
                temp = result;
            }else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
        }
        if(carry == 1) temp.next = new ListNode(1);
        return result;
    }

    private void printList(ListNode head){
        while(head.next !=null){
            System.out.print(head.val+" -> ");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        DayOne d1 = new DayOne();
        /*
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]
         */
        ListNode list1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null)))))));
        ListNode list2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));

        d1.printList(list1);
        d1.printList(list2);
        d1.printList(d1.addTwoNumbers(list1, list2));
    }

}