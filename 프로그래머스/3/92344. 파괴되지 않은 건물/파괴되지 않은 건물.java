import java.util.*;

class Solution {

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[] type = {0, -1, 1};
        int[][] sum = new int[board.length + 1][board[0].length + 1];

        for (int[] s : skill) {
            sum[s[1]][s[2]] += type[s[0]] * s[5];
            sum[s[1]][s[4] + 1] += type[s[0]] * s[5] * (-1);
            sum[s[3] + 1][s[2]] += type[s[0]] * s[5] * (-1);
            sum[s[3] + 1][s[4] + 1] += type[s[0]] * s[5];
        }

        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length - 1; j++) {
                sum[i][j + 1] += sum[i][j];
            }
        }

        for (int i = 0; i < sum[0].length; i++) {
            for (int j = 0; j < sum.length - 1; j++) {
                sum[j + 1][i] += sum[j][i];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += sum[i][j];
                if (board[i][j] >= 1) {
                    answer++;
                }
            }
        }

        return answer;
    }
}