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
int N, arr[20][20], dp[1<<20];

int allo(int bt, int idx) 
{
	if (idx == N) return 0;
	int& res = dp[bt];
	if (res != -1) return res;
	res = 1e9;
	for (int i = 0; i < N; i++)
		if (!(bt & (1 << i)))	// i번째 사람이 일을 안했으면
			res = min(res, arr[idx][i] + allo(bt | (1 << i), idx + 1));	// bt에 1<<i 추가
	return res;
}

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;

	for (int i = 0; i < N; i++)
		for (int j = 0; j < N; j++) cin >> arr[i][j];

	memset(dp, -1, sizeof(dp));
	int res = 1e9;

	for (int i = 0; i < N; i++) res = min(res, arr[0][i] + allo(1 << i, 1));
	// 첫번째 일하는 사람이 i번째 선택했을 때 

	cout << res;
}