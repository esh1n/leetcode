package com.esh1n;

public class AddTwoNumbers {

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1,l2);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        ListNode currentNode = null;
        boolean increaseNext = false;
        do {
            int sum = l1.val + l2.val;
            int finalSum = increaseNext ? sum + 1 : sum;
            increaseNext = finalSum >= 10;
            if (finalSum >= 0) {
                finalSum = finalSum % 10;
            }
            ListNode newNode = new ListNode(finalSum);
            if (resultNode == null) {
                resultNode = newNode;
                currentNode = newNode;
            } else {
                currentNode.next = newNode;
                currentNode = newNode;
            }
            l1 = l1.next;
            l2 = l2.next;

        } while (l1 != null);
        return resultNode;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


}
