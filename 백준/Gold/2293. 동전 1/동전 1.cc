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
int n, k, coin[101], dp[100001];

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> n >> k;
	for (int i = 1; i <= n; i++) cin >> coin[i];
	dp[0] = 1;
	for (int i = 1; i <= n; i++)
		for (int j = coin[i]; j <= k; j++)
			dp[j] += dp[j - coin[i]];

	cout << dp[k] << '\n';
}