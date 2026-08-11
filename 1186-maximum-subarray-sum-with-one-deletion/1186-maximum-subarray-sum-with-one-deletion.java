class Solution {
    public int maximumSum(int[] arr) {
        int nodel = arr[0];
        int n = arr.length;
        int onedel = Integer.MIN_VALUE;
        int res = arr[0]; int i;
        for(i=1; i<n; i++) {
            int prevnodel = nodel;
            int prevonedel = onedel;
            nodel = Math.max(nodel + arr[i], arr[i]);   
            if (prevonedel == Integer.MIN_VALUE) {
                onedel = prevnodel;
            } else {
                onedel = Math.max(prevnodel, prevonedel + arr[i]);
            } 
            res = Math.max(res, Math.max(onedel, nodel));
        }
        return res;
    }
}
