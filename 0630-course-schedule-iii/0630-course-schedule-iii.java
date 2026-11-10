class Solution {
    public int scheduleCourse(int[][] courses) {
        int n = courses.length; int i; int total = 0;
        // MAX HEAP
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // sorting it 
        Arrays.sort(courses,Comparator.comparingInt(course -> course[1]));
        for(i=0;i<n;i++) {
        pq.add(courses[i][0]); // addding current course duration 
        total += courses[i][0]; // updating the total
        if(total > courses[i][1]) // checking whether the total is greater than current course lastday
        {
            total -= pq.poll();
        }
        }
        return pq.size();
    }
}