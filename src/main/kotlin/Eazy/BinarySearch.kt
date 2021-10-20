package Eazy/*
https://leetcode.com/problems/binary-search/
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
*/

class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        val length = (nums.count() - 1)
        val searchPoint = length / 2
        if (nums[searchPoint] == target) {
            return searchPoint
        }
        if(nums[searchPoint] < target) {
            for (i in searchPoint .. length) {
                if (nums[i] == target) {
                    return i
                }
            }
        } else {
            for (i in searchPoint downTo 0) {
                if (nums[i] == target) {
                    return i
                }
            }
        }
        return -1
    }
}
