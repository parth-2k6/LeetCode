class Solution {
    public boolean isHappy(int n) {
        int slow = fun(n);          
        int fast = fun(fun(n)); 
        while (fast != 1 && slow != fast) {
            slow = fun(slow);          
            fast = fun(fun(fast));     
        }
        return fast == 1;
    }
    private int fun(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n = n / 10;
        }
        return sum;
    }
}