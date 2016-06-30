/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
*/
public class Solution {
    /*public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> row = new ArrayList<Integer>();//空间复杂度o(m+n)
        List<Integer> col = new ArrayList<Integer>();
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for (int i=0; i<rows; i++){
            for (int j=0; j<cols; j++){
                if (row.contains(i) || col.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }*/
    
    //参考资料http://www.mamicode.com/info-detail-1081259.html
    public void setZeroes(int[][] matrix) {
        boolean firstRow = false;
        boolean firstCol = false;
        int rows = matrix.length;
        int cols = matrix[0].length;
        //set first row and column zero or not
        for (int j=0; j<cols; j++){//不能用第一行来记录数据,否则 1 2 3；0 5 6 --> 0 2 3；0 5 6
            if (matrix[0][j] == 0){
                firstRow = true;
                break;
            }
        }
        for (int i=0; i<rows; i++){
            if (matrix[i][0] == 0){
                firstCol = true;
                break;
            }
        }
         //mark zeros on first row and column
        for (int i=1; i<rows; i++){
            for (int j=1; j<cols; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //use mark to set elements
        for (int i=1; i<rows; i++){
            for (int j=1; j<cols; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
         //set first column and row
        if (firstRow){
            for (int j=0; j<cols; j++){
                matrix[0][j] = 0;
            }
        }
        if (firstCol){
            for (int i=0; i<rows; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
