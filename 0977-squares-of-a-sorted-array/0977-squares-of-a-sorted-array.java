class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int res [] = new int[n];
        int i =0; int j= n-1; int p= n-1;
        while(i<=j) {
            int sq1 = nums[i]*nums[i];
            int sq2 = nums[j]*nums[j];
            if(sq1>sq2) {
                res[p]=sq1;
                i++;
            }
            else {
                res[p]=sq2;
                j--;
            }
            p--;
        }
        return res;
    }
}