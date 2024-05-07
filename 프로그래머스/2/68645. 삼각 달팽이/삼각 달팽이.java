class Solution {
	public int[] solution(int n) {
		int[][] arr = new int[n][n];
		int num = 1;
		int x = 0;
		int y = 0;
		int maxValue=n*(n+1)/2;
        int[] answer=new int[maxValue];
		int direction = 0; // 0 : 밑으로, 1: 옆으로, 2:축소
		// n -> 1~n까지 합
		//  x 확 -> y확 -> x,y 축소 반복
		while (num<=maxValue) {
			arr[x][y] = num++;
			if (direction == 0) {
				if (x+1 >= n || arr[x + 1][y] != 0) {
					direction = 1;
					y++;
				} else
					x++;
			} else if (direction == 1) {
				if (y+1 >= n || arr[x][y + 1] != 0) {
					direction = 2;
					x--;
					y--;
				} else
					y++;
			} else {
				if (x+1 < 0 || y+1 < 0 || arr[x - 1][y - 1] != 0) {
					direction = 0;
					x++;
				} else {
					x--;
					y--;
				}
			}
		}
        
        int idx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                answer[idx++]=arr[i][j];
            }
        }

		return answer;
	}
}