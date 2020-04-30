package com.marlinl.leetcode.problems;

/**
 * Problems source: <url>https://leetcode-cn.com/problems/add-two-numbers/</url>
 * Cost: 2ms
 * Memory: 40.1 MB
 *
 * @author marlinl
 * @version 1.0
 * @date 2020/4/30 10:17 PM
 */
public class AddTwoNumbers {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode result = new ListNode(0);
        ListNode current = result;
        while (true) {
            int value = 0;
            if (carry) {
                value++;
                carry = false;
            }
            if (l1 == null && l2 == null) {
                if (value > 0) {
                    current.next = new ListNode(value);
                }
                break;
            } else if (l1 == null) {
                value += l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                value += l1.val;
                l1 = l1.next;
            } else {
                value += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (value > 9) {
                carry = true;
                value -= 10;
            }
            current.next = new ListNode(value);
            current = current.next;
        }
        return result.next;
    }


}



