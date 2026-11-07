class Solution {
    class Pair{
        char ch; int count;
        Pair(char ch,int count) {
            this.ch=ch;
            this.count=count;
        }
    }
    public String reorganizeString(String s) {
        int freq[]=new int[26];
        for(char c: s.toCharArray()) {
            freq[c-'a']++;
        }
        // max heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.count - a.count);
        int i;
        for(i=0;i<26;i++) {
            if(freq[i]>0) {
                if(freq[i]>(s.length()+1)/2) {
                    return "";
                }
                char character = (char) (i+'a'); // konsa character hai
                pq.add(new Pair(character,freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=p.ch) {
                sb.append(p.ch); // p ko rakkho
                p.count--;
                if(p.count>0)
                pq.add(p);
            }
            else {
                if(pq.isEmpty()) {
                   return ""; 
                }
                Pair p1 = pq.poll();
                sb.append(p1.ch);
                p1.count--;
                if(p1.count > 0)
                pq.add(p1);
                pq.add(p);
                }
            } // end of while
            return sb.toString();
        }
    }