package org.zonghan.leetcode

//https://leetcode-cn.com/problems/add-two-numbers/
object AddTwoNumbers extends App {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  def listNodeToInt(l: ListNode): Long = {
    var n = l
    var value = 0L
    var len = 0
    while (n != null) {
      value = value + n.x * math.pow(10, len).toLong
      n = n.next
      len = len + 1
    }
    value
  }

  def intToListNode(value: BigInt): ListNode = {
    var valueS = value.toString
    val l = new ListNode(valueS(valueS.length - 1).toString.toInt)
    valueS = valueS.substring(0, valueS.length - 1)
    if (!valueS.isEmpty) {
      l.next = intToListNode(valueS.toLong)
    }
    l
  }

  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val l1Value = listNodeToInt(l1)
    val l2Value = listNodeToInt(l2)
    val l3Value = l1Value + l2Value
    intToListNode(l3Value)
  }

  val result = addTwoNumbers(intToListNode(BigInt(1001)), intToListNode(564))

  def printListNode(l: ListNode): Unit = {
    var n = l
    while (n != null) {
      println(n.x)
      n = n.next
    }
  }

  printListNode(result)


}
