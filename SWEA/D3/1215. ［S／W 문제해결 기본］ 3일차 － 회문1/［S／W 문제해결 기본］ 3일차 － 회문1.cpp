#include<iostream>
#include<string>
#include<vector>
#include<cstring>
#include<cmath>
using namespace std;

char pad[8][8];
int cnt;
bool check_row(int start, int end, int row_idx) {
	while (start <= end) {
		if (pad[row_idx][start] != pad[row_idx][end]) return false;
		start++;
		end--;
	}

	return true;
}

bool check_col(int start, int end, int col_idx) {
	while (start <= end) {
		if (pad[start][col_idx] != pad[end][col_idx]) return false;
		start++;
		end--;
	}

	return true;
}

int main(int argc, char** argv)
{
	int test_case;
	int T = 10;

	
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N;
		string plr;
		cin >> N;
		for (int i = 0; i < 8; i++) {
			cin >> plr;
			for (int j = 0; j < 8; j++)
				pad[i][j] = plr[j];
		}
		cnt = 0;
		int start = 0;
		int end = N - 1;
		while (end < 8) {
			for (int i = 0; i < 8; i++) {
				if (check_row(start, end, i)) cnt++;
				if (check_col(start, end, i)) cnt++;
			}
			start++;
			end++;
		}
		cout << "#" << test_case << " " << cnt << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}