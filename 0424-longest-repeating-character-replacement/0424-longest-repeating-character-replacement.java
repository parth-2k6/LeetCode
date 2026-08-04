class Solution {
     private int find(int[] a) {
        int maxc = -1;
        for (int i = 0; i < 256; i++) {
            maxc = Math.max(maxc, a[i]);
        }
        return maxc;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] f = new int[256];
        int low =0; int high; int res= Integer.MIN_VALUE;
        for(high=0;high<n;high++) {
            f[s.charAt(high)]++;
            int len=high-low+1;
            int maxc=find(f);
            int diff = len -maxc;
            while(diff>k) {
                f[s.charAt(low)]--;
                low++;
                maxc= find(f);
                len = high -low+1;
                diff = len - maxc;
            }
            len = high - low +1;
            res = Math.max(len,res);
        }
        return res;
    }
}