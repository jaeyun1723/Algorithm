class Solution {

    public int[] solution(String s) {
        int convert = 0;
        int zeroSum = 0;
        while (!s.equals("1")) {
            convert++;
            int org = s.length();
            s = s.replace("0", "");
            int len = s.length();
            zeroSum += org - len;
            s = Integer.toBinaryString(len);
        }
        return new int[]{convert, zeroSum};
    }
}