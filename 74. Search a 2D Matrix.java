/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols -1;
        while (row<rows && col>=0){
            if (matrix[row][col] == target){
                result = true;
                break;
            } else if (matrix[row][col] > target){
                col--;
            } else {
                row++;
            }
        }
        return result;
    }
}
