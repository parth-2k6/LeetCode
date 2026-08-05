class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int low=0; int high; int c=0; int res=Integer.MIN_VALUE;
        for (high =0;high<n;high++) {
            if(nums[high]==0)
            c++;
        
        while(c>k) {
            if(nums[low]==0) {
                c--;
            }
            low++;
        }
        int len = high -low +1;
        res = Math.max(len,res);
    }
    return res;
} }