import java.util.Arrays;
class Solution {
    public int pivotIndex(int[] nums) {
       int left = 0; 
       int n = nums.length; 
       int i; int right;
       int sum = Arrays.stream(nums).sum();
       for(i = 0; i < n; i++) {
        right = sum - nums[i] - left;
        if(left == right) {
            return i;
        }
        left += nums[i];
       }
       return -1;
       }
}