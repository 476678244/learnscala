package org.zonghan.y2022;

/*
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * */
public class ReverseListSolution {

    public static ListNode reverseList(ListNode head) {
        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(
                1, new ListNode(
                2, new ListNode(
                3, new ListNode(
                4, new ListNode(5)
        ))));
        reverseList(root).printList();
    }
}
