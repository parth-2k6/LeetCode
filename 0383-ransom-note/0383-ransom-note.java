class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap <Character,Integer> have = new HashMap<>();
        HashMap <Character,Integer> need = new HashMap<>();
        int rlen = ransomNote.length();
        int mlen = magazine.length();
        int i;
        for(i=0;i<rlen;i++) {
            char ch = ransomNote.charAt(i);
            need.put(ch,need.getOrDefault(ch,0)+1);
        }
        for(i=0;i<mlen;i++) {
            char ch = magazine.charAt(i);
            have.put(ch,have.getOrDefault(ch,0)+1);
        }
        for(char ch: need.keySet()) {
            int needed = need.get(ch);
            int available = have.getOrDefault(ch,0);
            if(available < needed) {
                return false;
            }
        }
        return true;
    }
}