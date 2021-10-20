package Eazy/*
https://leetcode.com/problems/reverse-string/
Write a function that reverses a string. The input string is given as an array of characters s.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/


class ReverseString {
    fun run() {
        reverseString("A man, a plan, a canal: Panama".toCharArray())
    }

    fun reverseString(s: CharArray): Unit {
        val len = s.size
        val mid = len/2
        for(i in 0..mid-1) {
            val lstIdx = len-1-i
            val leftVal = s[i]
            s[i] = s[lstIdx]
            s[lstIdx] = leftVal
        }
    }
}

//["A"," ","m","a","n",","," ","a"," ","p","l","a","n",","," ","a"," ","c","a","n","a","l",":"," ","P","a","n","a","m","a"]