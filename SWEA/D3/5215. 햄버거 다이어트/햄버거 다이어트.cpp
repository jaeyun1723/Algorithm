#include<iostream>
#include<string>
#include<vector>
#include<cstring>
#include<cmath>
using namespace std;

int score[21], kcal[21];
int dp[21][10001];
int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N, L;
		cin >> N >> L;
		for (int i = 1; i <= N; i++) {
			cin >> score[i] >> kcal[i];
		}
		memset(dp, 0, sizeof(dp));
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= L; j++) {
				if (kcal[i] <= j)
					dp[i][j] = max(dp[i - 1][j], score[i] + dp[i - 1][j - kcal[i]]);
				else
					dp[i][j] = dp[i - 1][j];
			}
		}

		cout << "#" << test_case << " " << dp[N][L] << '\n';
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}