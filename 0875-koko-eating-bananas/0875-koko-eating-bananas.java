class Solution {
    long fun(int[] a, int n, int speed) {
        long h = 0; n = a.length; 
        int i;
        for (i = 0; i < n; i++) {
            h = h + (a[i] / speed);
            if (a[i] % speed != 0) {
                h++;
            }
        }
        return h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = piles.length;
        int low = 1; int high = Arrays.stream(piles).max().getAsInt();
        int res = -1; 
        while (low <= high) {
            int guess = low + (high - low) / 2;
            long hours = fun(piles, l, guess);
            if (hours > h) {
                low = guess + 1;
            } else {
                res = guess;
                high = guess - 1;
            }
        }
        return res; 
    }
}