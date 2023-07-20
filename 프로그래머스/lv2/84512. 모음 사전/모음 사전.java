class Solution {
    static String[] vowel={"A","E","I","O","U"};
    static int answer=0, cnt=0;
    static String target;
    
    static void dictionary(String word){
      if(target.equals(word)){
          answer=cnt;
          return;
      }
      if(word.length()>=5||answer!=0)
          return;
        for(int i=0;i<vowel.length;i++){
            cnt++;
            dictionary(word+vowel[i]);
        }
    }
    public int solution(String word) {
        target=word;
        dictionary("");
        return answer;
    }
}