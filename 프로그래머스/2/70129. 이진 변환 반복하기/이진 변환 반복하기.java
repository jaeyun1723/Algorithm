class Solution {
    public int[] solution(String s) {
        int[] answer = {0,0};
        while(!s.equals("1")){
            answer[0]++;
            int cnt=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='0')
                    cnt++;
            }
            int len = s.length()-cnt;
            answer[1]+=cnt;
            s=Integer.toBinaryString(len);

        }
        return answer;
    }
}