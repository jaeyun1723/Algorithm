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
int N, v[16][16], dp[16][1 << 16];
//dp[i][j] : 현재 위치 i, j의 도시들을 방문했을 때 최솟값
int TSP(int cur, int stat) {
	if (stat == (1 << N) - 1) {
		if (v[cur][0] == 0) return 987654321;
		else return v[cur][0];
	}
	int& res = dp[cur][stat];
	if (res != -1) return res;
	res = 987654321;
	for (int i = 0; i < N; i++)
		if (!(stat & (1 << i)) && v[cur][i])
			res = min(res, v[cur][i] + TSP(i, stat | (1 << i)));
	return res;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++) cin >> v[i][j];

	memset(dp, -1, sizeof(dp));

	cout << TSP(0, 1);
}