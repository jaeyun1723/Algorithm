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
int N, res;
vector<int> v, dp;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	v.resize(N + 1), dp.resize(N + 1, 0);
	for (int i = 1; i <= N; i++) cin >> v[i], dp[i]=v[i];
	res = dp[1];
	for (int i = 1; i <= N; i++) {
		dp[i] = max(dp[i], dp[i - 1] + v[i]);
		if (dp[i] > res) res = dp[i];
	}
	cout << res << '\n';
}