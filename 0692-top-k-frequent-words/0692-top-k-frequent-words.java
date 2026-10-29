class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length; int i;
        HashMap <String,Integer> map = new HashMap<>();
        for(String w: words) {
            map.put(w,map.getOrDefault(w,0)+1);
        }
        PriorityQueue <String> pq = new PriorityQueue<>((a,b)->
        {
            if(map.get(a).equals(map.get(b))) {
                return b.compareTo(a);
            }
            return map.get(a)-map.get(b);
        });
        for(String w:map.keySet()) {
            pq.add(w);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        ArrayList<String> res = new ArrayList<>();
        while(!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }
}