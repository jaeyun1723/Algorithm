class Solution {

    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public long solution(int w, int h) {
        long gcd = gcd((long) w, (long) h);
        return (long) w * (long) h - (w / gcd + h / gcd - 1) * gcd;

    }
}