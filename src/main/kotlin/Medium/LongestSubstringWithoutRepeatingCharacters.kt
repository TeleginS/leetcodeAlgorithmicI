/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:
Input: s = ""
Output: 0
*/

package Medium

import kotlin.math.max

class LongestSubstringWithoutRepeatingCharacters {
    fun run(): Unit {
        var i:Int
        i = lengthOfLongestSubstring("abcabcbb")
        i = lengthOfLongestSubstring("bbbbb")
        i = lengthOfLongestSubstring("pwwkew")
        i = lengthOfLongestSubstring("")
        i = lengthOfLongestSubstring(" ")
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val size = s.length

        val hashM = HashMap<Char, Int>()
        var max = 0;
        var position = 0
        var i = 0
        while(position < size && i < size) {
            val v = s[i]
            if(hashM.containsKey(v)) {
                max = max(max, hashM.size)
                hashM.clear()
                position++
                i = position
            } else {
                hashM.put(v,i)
                max = max(max, hashM.size)
                i++
            }
        }

        return max
    }
}