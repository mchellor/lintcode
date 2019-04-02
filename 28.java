//28. Search a 2D Matrix

/*
  Treat the matrix as an array. Convert 2-D index into 1-D index.

*/

public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int col=matrix.length;
        if(col==0) return false;
        int row=matrix[0].length;
        int end=col*row-1;
        return binarySearch(matrix, target, 0, end);
    }
    
    boolean binarySearch(int[][]m, int t, int start, int end){
        int col=m.length;
        int row=m[0].length;
        if(start > end) return false;
        if(start == end){
            return (m[start/row][start%row]==t);
        }
        int mid=(start+end)/2;
        if(m[mid/row][mid%row] == t){
            return true;
        }
        else if(m[mid/row][mid%row] > t){
            return binarySearch(m, t, start, mid);
        } 
        else{
            return binarySearch(m, t, mid+1, end);
        } 
    }
}