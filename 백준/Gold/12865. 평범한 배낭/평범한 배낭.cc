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
int N, K;
vector<pair<int, int>> arr;
vector<vector<int>> dp;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> K;	// 물품의 수 : N, 무게 : K
	for (int i = 0; i < N; i++) {
		int w, v;
		cin >> w >> v;
		arr.push_back({ w,v });
	}
	dp.resize(N + 1, vector<int>(K + 1, 0));	// dp[i][j]= k : i번째 물건까지 왔고, 가방의 무게가 j일때 가방에 담긴 물건들의 가치는 k
	for (int i = 1; i <= N; i++) {	// i : i번째 물건
		int weight = arr[i - 1].first, value = arr[i - 1].second;
		for (int j = 1; j <= K; j++) {	// j : 무게 합 
			if (j >= weight) dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight] + value);
			else dp[i][j] = dp[i - 1][j];
		}
	}
	cout << dp[N][K];
}