
object ScalaSearchRange extends App {

  /*
    * 在排序数组中查找元素的第一个和最后一个位置
    * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    * Example:
    *   nums: [5, 7, 7, 8, 8, 10]
    *   target: 8
    *   answer: [3,4]
    * 如果数组中不存在目标值 target，返回 [-1, -1]
    * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
    * */
  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    import java.util
    val existIdx = util.Arrays.binarySearch(nums, target)
    if (existIdx < 0) Array(-1, -1) else {
      Array(findOtherViaLast(nums, existIdx, target), findOtherViaNext(nums, existIdx, target))
    }
  }

  def findOtherViaNext(nums: Array[Int], idx: Int, target: Int): Int = {
    if (idx == nums.length - 1)
      idx
    else if (nums(idx + 1) != target)
      idx
    else findOtherViaNext(nums, idx + 1, target)
  }

  def findOtherViaLast(nums: Array[Int], idx: Int, target: Int): Int = {
    if (idx == 0)
      idx
    else if (nums(idx - 1) != target)
      idx
    else findOtherViaLast(nums, idx - 1, target)
  }

  println(searchRange(Array(5, 7, 7, 8, 8, 10), 8).mkString(","))
  println(searchRange(Array(5, 7, 7, 8, 8, 8, 10), 8).mkString(","))
  println(searchRange(Array(1), 1).mkString(","))
  println(searchRange(Array(), 8).mkString(","))
  println(searchRange(Array(2, 2), 2).mkString(","))
}

