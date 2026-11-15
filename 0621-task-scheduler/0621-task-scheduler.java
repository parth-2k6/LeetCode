class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        // MAX HEAP
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int cyc = n + 1;
            int taskCycle = 0;
            ArrayList<Integer> list = new ArrayList<>();
            while (cyc > 0 && !pq.isEmpty()) {
                int cur = pq.poll();
                if (cur > 1) {
                    list.add(cur - 1);
                }
                taskCycle++;
                cyc--;
            }
            // Add remaining tasks
            for (int remaining : list) {
                pq.add(remaining);
            }
       ans += (pq.isEmpty() ? taskCycle : n + 1);
        }

        return ans;
    }
}
