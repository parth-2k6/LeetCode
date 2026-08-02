class Solution {
    public int totalFruit(int[] fruits) {
       Map<Integer,Integer> map = new HashMap<>();
       int low = 0, high=0; int n = fruits.length; int res=0;
       for(high=0;high<n;high++) {
        if(map.containsKey(fruits[high])) {
            map.put(fruits[high],map.get(fruits[high])+1);
        }
        else {
            map.put(fruits[high],1);
        }
        while(map.size()>2) {
        map.put(fruits[low],map.get(fruits[low])-1);
        if(map.get(fruits[low])==0) {
            map.remove(fruits[low]);
        }
        low++;
        }
        int len = high-low +1;
         res=Math.max(len,res);
       }
    return res;
    }
}