package org.zonghan.y2022

//https://leetcode.cn/problems/permutations/
object FullPermuteSolution extends App {

  /*
  * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
  示例 1：
  输入：nums = [1,2,3]
  输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  示例 2：
  输入：nums = [0,1]
  输出：[[0,1],[1,0]]
  示例 3：
  输入：nums = [1]
  输出：[[1]]
  * */

  def permute(nums: Array[Int]): List[List[Int]] = {
    List(List(0, 1), List(1, 1))
  }

  printPermute(permute(Array(1, 2, 3)))
  printPermute(permute(Array(0, 1)))
  printPermute(permute(Array(1)))

  def printPermute(p: List[List[Int]]): Unit = {
    val line = p.map(_.mkString(",")).mkString(" | ")
    println(line)
  }
}
