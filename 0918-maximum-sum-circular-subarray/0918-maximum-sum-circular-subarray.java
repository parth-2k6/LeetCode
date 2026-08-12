class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxsum = nums[0];
        int res = nums[0]; int i;
        for(i=1;i<n;i++) {
            res = Math.max(nums[i],res+nums[i]);
            maxsum = Math.max(res,maxsum);
        }
        int totalsum=0;
        for(int num:nums) {
            totalsum += num;
        }
        int minsum = nums[0];
        int resmin = nums[0];
        for(i=1;i<n;i++) {
            resmin = Math.min(nums[i],resmin+nums[i]);
            minsum =  Math.min(minsum,resmin);
        }
        int ans;
        if(minsum==totalsum) {
            ans = minsum;
        }
        else {
            ans = totalsum - minsum;
            }
            return Math.max(ans,maxsum);
    }
}