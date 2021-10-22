/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false
val Q = 1000000007
*/

package Medium

class PermutationInString {
    fun run() {
//        checkInclusion("ab", "eidbaooo")
//        checkInclusion("adc","dcda")
        print(checkInclusion("abc", "bbbca"))
    }

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val alphabetSize = 26
        val s1map = IntArray(alphabetSize)
        val s2map = IntArray(alphabetSize)

        for(i in s1.indices) {
            s1map[s1[i] - 'a']++
            s2map[s2[i] - 'a']++
        }

        var count = 0
        for(i in 0 until alphabetSize) {
            if(s1map[i] == s2map[i])
                count++
        }


        for(i in 0 until s2.length - s1.length) {
            val r = s2[i + s1.length] - 'a'
            val l = s2[i] - 'a'
            if (count == alphabetSize) return true

            s2map[r]++
            if(s2map[r] == s1map[r]) count++
            else if(s2map[r] == s1map[r] + 1) count--

            s2map[l]--
            if (s2map[l] == s1map[l]) count++
            else if (s2map[l] == s1map[l] - 1) count--
        }

        return count == alphabetSize;
    }

}