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

int n, wine[10001], dp[10001];
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> wine[i];
	dp[1] = wine[1], dp[2] = wine[1] + wine[2];

	for (int i = 3; i <= n; i++)
		dp[i] = max(max(dp[i - 3] + wine[i - 1] + wine[i], dp[i - 2] + wine[i]), dp[i - 1]);
	cout << dp[n] << '\n';
}