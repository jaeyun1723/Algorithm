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
int M, N, cnt;
int X[4] = { -1,0,0,1 };
int Y[4] = { 0,1,-1,0 };
vector<vector<int>> v;
vector<vector<int>> dp;
int dfs(int x, int y) {
	if (dp[x][y] != -1) return dp[x][y];
	if (x == M && y == N) return 1;
	dp[x][y] = 0;
	for (int i = 0; i < 4; i++) {
		int next_x = x + X[i], next_y = y + Y[i];
		if (next_x >= 1 && next_y >= 1 && next_x <= M && next_y <= N)
			if (v[next_x][next_y] < v[x][y])
				dp[x][y] += dfs(next_x, next_y);
	}
	return dp[x][y];
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> M >> N;
	v.resize(M + 1, vector<int>(N + 1, 0));
	dp.resize(M + 1, vector<int>(N + 1, -1));
	for (int i = 1; i <= M; i++)
		for (int j = 1; j <= N; j++) cin >> v[i][j];
	cout << dfs(1, 1) << '\n';
}