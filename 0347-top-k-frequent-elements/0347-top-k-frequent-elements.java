import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length; int i;
        PriorityQueue <int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0])
                return a[0] - b[0]; //min
            return Integer.compare(a[1], b[1]);
        });
        HashMap<Integer,Integer> map = new HashMap<>();
        for(i=0;i<n;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
        }
        // Important pair making 
        map.forEach((element,freq)->
        {
            int[] curr = {freq,element};
            if(pq.size() < k) { 
                pq.add(curr);
                return;
            }
            if(curr[0] < pq.peek()[0]) 
                return;
            pq.poll();
            pq.add(curr);
        }
        );
        // Directly filling the required int[] array instead of a List
        int[] res = new int[k];
        int index = 0;
        while(!pq.isEmpty()) {
            res[index++] = pq.peek()[1];
            pq.poll();
        }
        return res;
    }
}