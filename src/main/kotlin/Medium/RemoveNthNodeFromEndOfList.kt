/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]
*/


package Medium

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var h = head
        var nBehind: ListNode? = null
        var iterations = 0

        // Loop through linked list until we reach the end
        while (h != null) {
            h = h.next
            nBehind = nBehind?.next

            // Once we iterate N times, make a pointer for the 'nthBehind' element
            // After this loop finishes we will hotswap to 'skip' the element
            if (iterations == n) {
                nBehind = head
            }
            iterations++
        }

        // Got here, head points to nothing
        // Hotswap nBehind to skip what it points to
        nBehind?.next = nBehind?.next?.next

        //Return -- if N was too big then we just remove 1 layer from head
        return if (iterations <= n) {
            head?.next
        } else {
            head
        }
    }
}
