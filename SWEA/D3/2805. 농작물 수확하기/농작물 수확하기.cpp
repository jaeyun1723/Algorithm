#include<iostream>

using namespace std;

int farm[50][50];

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N;
		cin >> N;
		for (int i = 0; i < N; i++) {
			string s;
			cin >> s;
			for (int j = 0; j < N; j++)
				farm[i][j] = s[j] - '0';
		}
		int mid = N / 2;
		int cnt = 0;
		int start, end;
		for (int row = 0; row <= mid; row++) {
			start = mid - row;
			end = mid + row;
			for (start; start <= end; start++)
				cnt += farm[row][start];
		}
		int rrow = 0;
		for (int row = N - 1; row > mid; row--) {
			start = mid - rrow;
			end = mid + rrow;
			for (start; start <= end; start++)
				cnt += farm[row][start];
			rrow++;
		}
		cout << "#" << test_case << " " << cnt << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}