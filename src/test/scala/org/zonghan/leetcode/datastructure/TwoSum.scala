package org.zonghan.leetcode.datastructure

//https://leetcode-cn.com/problems/two-sum/
object TwoSum extends App {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val meaningFulOpt = nums.sorted
    val targetMean = target / 2 + 1
    meaningFulOpt.indices.foreach(i => {
      val rightOpt = findRight(meaningFulOpt, target - meaningFulOpt(i), targetMean)
      if (rightOpt > 0) {
        return Array(nums.indexOf(meaningFulOpt(i)), nums.lastIndexOf(meaningFulOpt(rightOpt)))
      }
    })

    def findRight(meaningFulOpt: Array[Int], rightTarget: Int, targetMean: Int): Int = {
      val len = meaningFulOpt.length
      for (i <- meaningFulOpt.indices) {
        val rightIdx = len - i - 1
        if (meaningFulOpt(rightIdx) == rightTarget) {
          return rightIdx
        } else if (meaningFulOpt(rightIdx) < targetMean) {
          return -1
        }
      }
      -1
    }

    Array(0, 0)
  }

  var nums: Array[Int] = Array(0)
  var target = 0

  nums = Array(2, 7, 11, 15)
  target = 9
  println(twoSum(nums, target).mkString("Array(", ", ", ")"))

  nums = Array(3, 2, 4)
  target = 6
  println(twoSum(nums, target).mkString("Array(", ", ", ")"))

  nums = Array(-3, 3)
  target = 0
  println(twoSum(nums, target).mkString("Array(", ", ", ")"))
}
