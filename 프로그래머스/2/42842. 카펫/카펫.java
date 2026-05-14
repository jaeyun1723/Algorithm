class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        
        // 세로(row)는 최소 3부터 시작 (노란색이 최소 1칸이려면 세로가 최소 3이어야 함)
        for (int row = 3; row <= sum; row++) {
            if (sum % row == 0) {
                int col = sum / row; // 가로 길이 계산               
                // 조건 1: 가로(col)는 세로(row)보다 길거나 같아야 함
                // 조건 2: (가로-2) * (세로-2)가 내부 노란색 격자 수와 일치해야 함
                if (col >= row) {
                    if ((col - 2) * (row - 2) == yellow) {
                        return new int[]{col, row};
                    }
                }
            }
        }
        return new int[]{};
    }
}