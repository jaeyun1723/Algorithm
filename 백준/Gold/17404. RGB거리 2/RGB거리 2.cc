#include<iostream>
#include<string>
#include<cstring>
#include<vector>
#include<cmath>
#include<cstring>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
#include<bitset>
using namespace std;

typedef long long ll;
int N, cost[1001][3], dp[1001][3];

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	int res = 987654321;
	for (int i = 1; i <= N; i++)
		cin >> cost[i][0] >> cost[i][1] >> cost[i][2];

	for (int i = 0; i < 3; i++) {	// k가 R G B순으로 시작
		for (int k = 0; k < 3; k++)	// 원형이기 때문에 R G B로 시작할 때 정보 기억 
			if (i == k) dp[1][k] = cost[1][k];
			else dp[1][k] = 1001;
		for (int k = 2; k <= N; k++) {
			dp[k][0] = min(dp[k - 1][1], dp[k - 1][2]) + cost[k][0];
			dp[k][1] = min(dp[k - 1][0], dp[k - 1][2]) + cost[k][1];
			dp[k][2] = min(dp[k - 1][0], dp[k - 1][1]) + cost[k][2];
		}
		for (int k = 0; k < 3; k++)
			if (k != i) res = min(res, dp[N][k]);
	}
	cout << res;
}