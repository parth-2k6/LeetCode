class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> res = new ArrayList<>();
        int[] start = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            int[] interval = list.get(i);
            if (start[1] >= interval[0]) {
                start[1] = Math.max(start[1], interval[1]);
            } else {
                res.add(start);
                start = interval;
            }
        }
        res.add(start);
        return res.toArray(new int[res.size()][]);
    }
}