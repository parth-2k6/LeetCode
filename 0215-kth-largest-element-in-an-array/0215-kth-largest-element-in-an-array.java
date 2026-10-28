class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length; int i;
        PriorityQueue <Integer> pq = new PriorityQueue<>(); // Min Heap
        for(i=0;i<k;i++) {
            pq.add(nums[i]);
        }
        for(i=k;i<n;i++) {
            if(nums[i]<=pq.peek()){
                continue;
            }
            pq.poll();
            pq.add(nums[i]);
        }
    return pq.peek();
    }
}