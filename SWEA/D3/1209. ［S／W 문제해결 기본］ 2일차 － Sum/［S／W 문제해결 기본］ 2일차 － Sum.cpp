#include<iostream>
#include<cstring>
using namespace std;


int arr[100][100];
int cnt;
int sum_row[100];
int sum_col[100];
int main(int argc, char** argv)
{
	int test_case;
	int T;

	T = 10;

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N;
		cin >> N;
		int num;
		cnt = 0;
		int diagonal_left, diagonal_right;
		diagonal_left = diagonal_right = 0;
		memset(sum_row, 0, sizeof(sum_row));
		memset(sum_col, 0, sizeof(sum_row));
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				cin >> arr[i][j];
				sum_row[i] += arr[i][j];
				sum_col[j] += arr[i][j];
				if (i == j) diagonal_left += arr[i][j];
				if (i + j == 99) diagonal_right += arr[i][j];
			}
		}
		cnt = (diagonal_left > diagonal_right) ? diagonal_left : diagonal_right;
		for (int i = 0; i < 100; i++) {
			int num = (sum_row[i] > sum_col[i]) ? sum_row[i] : sum_col[i];
			cnt = (cnt > num) ? cnt : num;
		}

		cout << "#" << test_case << " " << cnt << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}