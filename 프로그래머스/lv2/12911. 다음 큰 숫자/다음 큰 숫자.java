class Solution {
    public int solution(int n) {
        int answer = 0;
        String condition= Integer.toBinaryString(n);
        condition=condition.replace("0","");
        answer=condition.length();
        while(true){
            String number= Integer.toBinaryString(++n);
            number=number.replace("0","");
            if(number.length()==answer) return answer=n;
        }
      
    }
}