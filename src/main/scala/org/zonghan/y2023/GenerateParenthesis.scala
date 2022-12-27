package org.zonghan.y2023

//https://leetcode.cn/problems/generate-parentheses/
object GenerateParenthesis extends App {

  /*
  * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    示例 1：
    输入：n = 3
    输出：["((()))","(()())","(())()","()(())","()()()"]
    示例 2：
    输入：n = 1
    输出：["()"]
  * */
  def generateParenthesis(n: Int): List[String] = {
    List()
  }

  println(s"N=${3} : ${generateParenthesis(3).mkString(",")}")

  println(s"N=${1} : ${generateParenthesis(1).mkString(",")}")

}
