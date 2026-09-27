class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap <Character,Integer> have = new HashMap<>();
        int i; int n = text.length();
        for(char ch: text.toCharArray()) {
            have.put(ch,have.getOrDefault(ch,0)+1);
        }
        String ransom = "balloon";
        int res = Integer.MAX_VALUE;
        for (char ch: ransom.toCharArray()) {
            int having = have.getOrDefault(ch,0);
            if(ch=='l' || ch=='o')
            having /=2;
            res = Math.min(res,having);
        }
        return res;
    }
}