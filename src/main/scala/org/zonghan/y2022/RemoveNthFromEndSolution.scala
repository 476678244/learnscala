package org.zonghan.y2022

object RemoveNthFromEndSolution extends App {
  // 快慢指针
  /* https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
  *  给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。
    示例 1：
    输入：head = [1,2,3,4,5], n = 2
    输出：[1,2,3,5]
    示例 2：

    输入：head = [1], n = 1
    输出：[]
    示例 3：

    输入：head = [1,2], n = 1
    输出：[1]
  * */

  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    val returnHead = head
    returnHead
  }

  val case1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))
  ListNode.staticPrintList(removeNthFromEnd(case1, 2))
  val case2 = new ListNode(1)
  ListNode.staticPrintList(removeNthFromEnd(case2, 1))
  val case3 = new ListNode(1, new ListNode(2))
  ListNode.staticPrintList(removeNthFromEnd(case3, 1))
}
