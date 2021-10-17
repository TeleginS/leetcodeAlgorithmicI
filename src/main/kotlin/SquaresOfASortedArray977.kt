/*
https://leetcode.com/problems/squares-of-a-sorted-array/
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

class SquaresOfASortedArray977 {

    fun run() {
        var nums: Array<Int>
        var result: IntArray

        nums = arrayOf<Int>(-4, -1, 0, 3, 10)
        result = sortedSquares(nums.toIntArray())
        print(" Expected [0,1,9,16,100] Result: ${result.toString()} \n")
    }


    private fun sortedSquares(nums: IntArray): IntArray {
        val length = nums.size
        var left = 0
        var right = length - 1

        val squaredArray: MutableList<Int> = arrayListOf()

        while (left <= right) {
            if (left == right) {
                val value = nums[left]
                squaredArray.add(value * value)
            } else {
                val leftV = nums[left]
                val rightV = nums[right]
                val squareLeft = leftV * leftV
                val squareRight = rightV * rightV
                if (squareRight > squareLeft) {
                    squaredArray.add(squareLeft)
                    squaredArray.add(squareRight)
                } else {
                    squaredArray.add(squareRight)
                    squaredArray.add(squareLeft)
                }
            }

            left++
            right--
        }

        squaredArray.sort()
        return squaredArray.toIntArray()
    }
}