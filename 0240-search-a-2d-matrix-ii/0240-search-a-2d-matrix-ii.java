class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
           for (int i = 0; i < n; i++) {
            int low = 0; 
            int high = m - 1;
            while(low <= high) {
                int guess = (low+high)/2;
                if (matrix[i][guess] == target)
                    return true;
                else if (matrix[i][guess] < target)
                    low = guess + 1;
                else 
                    high = guess - 1;
            }
        }
        return false;
    } 
}