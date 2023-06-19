
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

class Solution
{
    static int T, N, result;
	static boolean[][] arr;

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new boolean[N][N];
			result = 0;
			nQueen(0);
			System.out.println("#" + i + " " + result);
		}
		}
    static void nQueen(int row) {
		if (row == N) {
			result++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isCorrect(row, i)) {
				arr[row][i] = true;
				nQueen(row + 1);
				arr[row][i] = false;
			}
		}
	}

	static boolean isCorrect(int row, int col) {
		// 세로
		for (int i = 0; i < row; i++)
			if (arr[i][col])
				return false;
		int i = row;
		int j = col;
		// \방향
		while (i >= 0 && j >= 0) {
			if (arr[i--][j--])
				return false;
		}
		// /방향
		while (row >= 0 && col < N) {
			if (arr[row--][col++])
				return false;
		}
		return true;
	}
}