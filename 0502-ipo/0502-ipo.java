import java.util.*;

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<int[]> projects = new ArrayList<>();
        int i; int idx = 0;
        for(i=0;i<n;i++) { 
            projects.add(new int[]{capital[i],profits[i]});
        }
        projects.sort((a,b) -> a[0]!=b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1]));
        
        // Max Heap
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(k-- > 0) {
            while(idx < n) {
                if(projects.get(idx)[0] > w)
                    break;
                pq.add(projects.get(idx)[1]); 
                idx++;
            }
            if(pq.isEmpty()) 
                return w; // bankrupt 
            w = w + pq.poll();
        }
        return w;
    }
}
