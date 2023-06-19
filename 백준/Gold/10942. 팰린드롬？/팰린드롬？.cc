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
int N, arr[2001];
int dp[2001][2001];

int palindrome(int start, int end) {
	if (start >= end) return 1;
	if (dp[start][end] != -1) return dp[start][end];
	int& res = dp[start][end];
	if (arr[start] != arr[end]) return res = 0;
	return res = palindrome(start + 1, end - 1);
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> arr[i];
		dp[i][i] = 1;
	}
	memset(dp, -1, sizeof(dp));
	int query;
	cin >> query;
	while (query--) {
		int st, en;
		cin >> st >> en;
		cout << palindrome(st, en) << '\n';
	}
}