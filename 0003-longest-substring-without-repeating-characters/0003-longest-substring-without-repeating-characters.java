class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low =0,high=0,res=0;
        Map <Character,Integer> map= new HashMap<>();
        for(high =0;high<n;high++) {
            char c = s.charAt(high);
            if(map.containsKey(c)) {
                low = Math.max(low,map.get(c)+1);
            }
            map.put(c,high);
            int len =high-low+1;
            res=Math.max(res,len);
        }
        return res;
    }
}