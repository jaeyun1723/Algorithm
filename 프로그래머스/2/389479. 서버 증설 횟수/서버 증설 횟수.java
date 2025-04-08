class Solution {

  public int solution(int[] players, int m, int k) {
    int answer = 0;
    // m : 서버 한 대 당 최대 이용자 수
    // k : 서버 한 대가 운영하는 시간
    int size = players.length;
    int[] server = new int[size];
    int now = 0;
    for (int i = 0; i < size; i++) {
      int need = players[i] / m;
      if (server[i] < need) {
        int plus = need - server[i];
        answer += plus;
        for (int j = i; j < Math.min(size, i + k); j++) {
          server[j] += plus;
        }
      }
    }
    return answer;
  }
}