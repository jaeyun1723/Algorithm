#include<iostream>
#include<string>
#include<vector>
#include<cstring>
#include<cmath>
using namespace std;

char pad[100][100];
int res;

void odd_check_row(int mid_ridx, int mid_cidx, int cnt) {
	int left, right;
	left = mid_cidx - 1;
	right = mid_cidx + 1;
	while (left >= 0 && right < 100) {
		if (pad[mid_ridx][left] != pad[mid_ridx][right]) break;
		left--;
		right++;
		cnt = cnt + 2;
	}
	if (cnt > res) res = cnt;
}

void even_check_row(int mid_ridx, int mid_cidx, int cnt){
	int left, right;
	left = mid_cidx - 1;
	right = mid_cidx + 2;
	while (left >= 0 && right < 100) {
		if (pad[mid_ridx][left] != pad[mid_ridx][right]) break;
		left--;
		right++;
		cnt = cnt + 2;
	}
	if (cnt > res) res = cnt;
}
void odd_check_col(int mid_ridx, int mid_cidx, int cnt) {
	int up, down;
	up = mid_ridx - 1;
	down = mid_ridx + 1;
	while (up >= 0 && down < 100) {
		if (pad[up][mid_cidx] != pad[down][mid_cidx]) break;
		up--;
		down++;
		cnt = cnt + 2;
	}
	if (cnt > res) res = cnt;
}
void even_check_col(int mid_ridx, int mid_cidx, int cnt) {
	int up, down;
	up = mid_ridx - 1;
	down = mid_ridx + 2;
	while (up >= 0 && down < 100) {
		if (pad[up][mid_cidx] != pad[down][mid_cidx]) break;
		up--;
		down++;
		cnt = cnt + 2;
	}
	if (cnt > res) res = cnt;
}
int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int num;
		cin >> num;
		string st;
		for (int i = 0; i < 100; i++) {
			cin >> st;
			for (int j = 0; j < 100; j++)
				pad[i][j] = st[j];
		}
		res = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				odd_check_row(i, j, 1);
				odd_check_col(i, j, 1);
				if (res == 100) break;
			}
			if (res == 100) break;
		}

		for (int i = 0; i < 99; i++) {
			for (int j = 0; j < 99; j++) {
				if (pad[i][j] == pad[i][j + 1])
					even_check_row(i, j, 2);
				if (pad[j][i] == pad[j + 1][i])
					even_check_col(j, i, 2);
				if (res == 100) break;
			}
			if (res == 100) break;
		}

		cout << "#" << test_case << " " << res << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}