package org.zonghan.leetcode


//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
object LongestSubstringWithoutRepeatingCharacters extends App {


  //*
  // "abcbebb"
  // "a" -> "ab" -> "abc" -> "cb" -> "cbe" -> "eb" -> "b"
  // *//
  def lengthOfLongestSubstring(s: String): Int = {
    val left = new scala.collection.mutable.Queue[String]()
    var cursor = ""
    var currentBest = cursor
    if (s.nonEmpty)
      left ++= s.split("")
    while (left.nonEmpty) {
      val value = left.dequeue()
      if (!cursor.contains(value)) {
        cursor += value
      } else {
        cursor = cursor.substring(cursor.lastIndexOf(value) + 1) + value
      }
      if(cursor.length > currentBest.length) {
        currentBest = cursor
      }
    }
    math.max(currentBest.length, cursor.length)
  }

  Array(
    lengthOfLongestSubstring(""),
    lengthOfLongestSubstring("abcabcbb"),
    lengthOfLongestSubstring("bbbbb"),
    lengthOfLongestSubstring("pwwkew")
  ).foreach(println(_))

}

