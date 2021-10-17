/*
https://leetcode.com/problems/reverse-words-in-a-string-iii/
Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"
*/

class ReverseWordsInAString3557 {
    fun run() {
        reverseWords("Let's take LeetCode contest")
    }

//    Stupid way
//    fun reverseWords(s: String): String {
//        return s
//            .split(" ")
//            .map { it ->
//                it.reversed()
//            }
//            .joinToString(" ")
//    }

    private fun reverseWords(s: String): String {
        val wordArray = s.split(' ')
        var result = ""
        for (wordIdx in wordArray.indices) {
            val rev = reverseString(wordArray[wordIdx].toCharArray())
            result = String.format("%s %s", result, rev)
        }
        return result.trim()
    }

    private fun reverseString(s: CharArray): String {
        val len = s.size
        val mid = len / 2
        for (i in 0..mid - 1) {
            val lstIdx = len - 1 - i
            val leftVal = s[i]
            s[i] = s[lstIdx]
            s[lstIdx] = leftVal
        }
        return s.joinToString("")
    }
}