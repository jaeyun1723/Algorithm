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
int N, tri[501][501], res[501][501];

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	for (int i = 1; i <= N; i++)
		for (int j = 1; j <= i; j++) {
			cin >> tri[i][j];
			res[i][j] = max(res[i - 1][j], res[i - 1][j - 1]) + tri[i][j];
		}
	int MAX = -1;
	for (int i = 1; i <= N; i++)
		MAX = max(res[N][i], MAX);
	cout << MAX << '\n';
}