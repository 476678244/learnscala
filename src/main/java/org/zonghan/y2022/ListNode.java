package org.zonghan.y2022;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printList() {
        ListNode p = this;
        System.out.print(p.val);
        while (p.next != null) {
            p = p.next;
            System.out.print("," + p.val);
        }
        System.out.println();
    }
}
