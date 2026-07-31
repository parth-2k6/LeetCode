class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;
        int wsum = 0;  int left = 0;
        for (int i = 0; i < n; i++) {
            wsum += nums[i];
            while (wsum >= target) {
                minLen = Math.min(minLen, i - left + 1);
                wsum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
