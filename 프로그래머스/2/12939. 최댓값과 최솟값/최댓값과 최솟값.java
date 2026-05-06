class Solution {
    public String solution(String s) {
        String[] answer = new String[2];
        String[] strArr = s.split(" ");
        answer[0]=answer[1]=strArr[0];
        for(String str : strArr){
            int num= Integer.parseInt(str);
            int min = Integer.parseInt(answer[0]);
            int max = Integer.parseInt(answer[1]);
            if(num<min)
                answer[0]=str;
            if(num>max)
                answer[1]=str;
        }
        return answer[0]+" "+answer[1];
    }
}