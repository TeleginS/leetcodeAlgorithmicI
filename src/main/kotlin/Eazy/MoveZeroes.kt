package Eazy/*
https://leetcode.com/problems/move-zeroes/
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */


class MoveZeroes {
    fun run() {
        print(" Expected [1,3,12,0,0] Result: ${moveZeroes(arrayOf(0, 1, 0, 3, 12).toIntArray())} \n")
    }

    private fun moveZeroes(nums: IntArray): Unit {
        var lastNonZeroAt = 0;

        for (num in nums) {
            if (num != 0) {
                nums[lastNonZeroAt++] = num
            }
        }

        for (i in lastNonZeroAt until nums.size) {
            nums[i] = 0;
        }
    }
}