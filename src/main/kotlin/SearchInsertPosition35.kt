/*
https://leetcode.com/problems/search-insert-position/

Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.
########################################
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
########################################
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
########################################
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
########################################
Example 4:
Input: nums = [1,3,5,6], target = 0
Output: 0
########################################
Example 5:
Input: nums = [1], target = 0
Output: 0
########################################

Constraints:
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
########################################
*/

class SearchInsertPosition35 {
    fun run() {
        var nums: Array<Int>
        var target: Int
        var result: Int

        nums = arrayOf<Int>(1, 3, 5, 6)
        target = 5//Expected 2
        result = searchInsert(nums.toIntArray(), target)
        print(" Expected 2 Result: $result \n")

        nums = arrayOf<Int>(1, 3, 5, 6)
        target = 2//Expected 1
        result = searchInsert(nums.toIntArray(), target)
        print(" Expected 1 Result: $result \n")

        nums = arrayOf<Int>(1, 3, 5, 6)
        target = 7//Expected 4
        result = searchInsert(nums.toIntArray(), target)
        print(" Expected 4 Result: $result \n")

        nums = arrayOf<Int>(1, 3, 5, 6)
        target = 0//Expected 0
        result = searchInsert(nums.toIntArray(), target)
        print(" Expected 0 Result: $result \n")

        nums = arrayOf<Int>(1)
        target = 2//Expected 1
        result = searchInsert(nums.toIntArray(), target)
        print(" Expected 1 Result: $result \n")

        nums = arrayOf<Int>(1)
        target = 0//Expected 0
        result = searchInsert(nums.toIntArray(), target)
        print(" Expected 0 Result: $result \n")

        nums = arrayOf<Int>(1, 3)
        target = 2//Expected 1
        result = searchInsert(nums.toIntArray(), target)
        print(" Expected 1 Result: $result \n")
    }

    private fun searchInsert(A: IntArray, target: Int): Int {
        val N = A.size
        var left = 0
        var right = N
        while (left < right) {
            val mid = left + (right - left) / 2
            if (A[mid] == target) {
                return mid
            }
            if (A[mid] > target) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }




//    fun searchInsert(nums: IntArray, target: Int): Int {
//        val length = nums.size
//        var left = 0
//        var right = length - 1
//        var pivot = 0
//
//        while (left <= right) {
//            pivot = left + (right - left) / 2;
//
//            val pivotNum = nums[pivot]
//
//            if (pivotNum == target) {
//                return pivot
//            }
//
//            if (pivot == length - 1 && target > pivotNum) {
//                return pivot + 1
//            }
//
//            if (pivot == 0 && target < pivotNum) {
//                return pivot
//            }
//
//            if (pivot > 0 && target > nums[pivot - 1] && target < pivotNum) {
//                return pivot
//            }
//
//            if (target < pivotNum) {
//                right = pivot - 1
//            } else {
//                left = pivot + 1
//            }
//        }
//
//        return pivot
//    }
}