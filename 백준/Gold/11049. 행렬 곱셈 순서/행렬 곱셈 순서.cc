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
pair<int, int> arr[501];
int dp[501][501];
int N, r, c;

int DP(int left, int right) {
	if (left == right) return 0;
	int res = 987654321;
	if (dp[left][right] != -1) return dp[left][right];
	for (int i = left; i < right; i++)
		res = min(res, DP(left, i) + DP(i + 1, right) + arr[left].first * arr[i].second * arr[right].second);
	dp[left][right] = res;
	return res;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++) cin >> arr[i].first >> arr[i].second;
	memset(dp, -1, sizeof(dp));
	cout << DP(1, N) << '\n';
}