class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length; int i;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(i=0;i<n;i++) {
            int x = points[i][0];
            int y = points[i][1];
            int dist = (x*x)+(y*y);
            if(pq.size()<k) {
                pq.add(new int[]{dist,i});
            }
            else {
                pq.add(new int[]{dist,i});
                pq.poll();
            }
        }
        int[][] res = new int[k][];
        for(i=0;i<k;i++) {
            res[i] = points[pq.poll()[1]];
        }
        return res;
    }
}