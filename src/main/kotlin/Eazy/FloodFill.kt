/*
https://leetcode.com/problems/flood-fill/

An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.

Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
Output: [[2,2,2],[2,2,2]]
*/

package Eazy

class FloodFill {
    fun run() {
        var image: Array<IntArray> = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 1)
        )
        var result = floodFill(image, 1, 1, 2)

        image = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
        )
        result = floodFill(image, 0, 0, 2)
        val i = 0
    }

//    naive
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val  intColor = image[sr][sc]
        if (intColor != newColor)
            dfs(image, sr, sc, intColor, newColor)
        return image
    }

    private fun dfs(image: Array<IntArray>, sr: Int, sc: Int, intColor: Int, newColor: Int) {
        if (image[sr][sc] == intColor) {
            image[sr][sc] = newColor
            if (sr >= 1) dfs(image, sr - 1, sc, intColor, newColor)
            if (sc >= 1) dfs(image, sr, sc - 1, intColor, newColor)
            if (sr + 1 < image.size) dfs(image, sr + 1, sc, intColor, newColor)
            if (sc + 1 < image[0].size) dfs(image, sr, sc + 1, intColor, newColor)
        }
    }

    //    faster
    fun floodFill2(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        val sColor = image[sr][sc]
        fun floodFill2(sr: Int, sc: Int) {
            if (sr in image.indices && sc in image[0].indices && image[sr][sc] == sColor) {
                image[sr][sc] = newColor
                setOf(1, -1).forEach { floodFill2(sr + it, sc); floodFill2(sr, sc + it) }
            }
        }
        if (sColor != newColor) floodFill2(sr, sc)
        return image
    }
}