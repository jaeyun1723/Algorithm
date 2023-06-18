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

int N;
int arr[1001][3];
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	arr[0][0] = arr[0][1] = arr[0][2] = 0;
	int cost[3];
	// arr[i][j] : i번째를 j로 칠했을 때 최솟값
	for (int i = 1; i <= N; i++) {
		cin >> cost[0] >> cost[1] >> cost[2];
		arr[i][0] = min(arr[i - 1][1], arr[i - 1][2]) + cost[0];
		arr[i][1] = min(arr[i - 1][0], arr[i - 1][2]) + cost[1];
		arr[i][2] = min(arr[i - 1][0], arr[i - 1][1]) + cost[2];
	}
	cout << min(arr[N][0], min(arr[N][1], arr[N][2])) << '\n';
}