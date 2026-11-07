class Solution {
    public int lastStoneWeight(int[] stones) {
        int x,y;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone : stones) {
            pq.offer(stone);
        }
        while(pq.size()>1) {
            x = pq.poll();
            y = pq.poll();
            if(x!=y) {
                pq.offer(x-y);
            }
        }
        return (pq.isEmpty() ? 0:pq.peek());
    }
}