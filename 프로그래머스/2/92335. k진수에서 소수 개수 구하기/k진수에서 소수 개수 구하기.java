class Solution {

    public String change(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    public boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        if (n == 1) {
            return 0;
        }
        String str = change(n, k);
        String[] num = str.split("0");
        for (int i = 0; i < num.length; i++) {
            if (num[i].isEmpty()) {
                continue;
            }
            if (isPrime(Long.parseLong(num[i]))) {
                answer++;
            }
        }
        return answer;
    }
}