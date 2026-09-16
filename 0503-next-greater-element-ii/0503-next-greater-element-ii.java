class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n]; 
        Stack<Integer> st = new Stack<>();
        int i;
        for(i = n - 1; i >= 0; i--) { 
            st.push(nums[i]);
        }   
        for(i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i])  {
                st.pop();
            } 
            if(st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }     
            st.push(nums[i]);
        } 
        return res;
    }
}