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

int a, b, c, dp[21][21][21];

int w(int x, int y, int z) {
	if (x <= 0 || y <= 0 || z <= 0) return 1;
	if (x > 20 || y > 20 || z > 20) return w(20, 20, 20);
	int& res = dp[x][y][z];
	if (res != 0) return res;	// 0으로 초기화되어있는데 해당 값이 0이면 아직 top-down이 진행 안된 것
	if (x < y && y < z) res = w(x, y, z - 1) + w(x, y - 1, z - 1) - w(x, y - 1, z);
	else
		res = w(x - 1, y, z) + w(x - 1, y - 1, z) + w(x - 1, y, z - 1) - w(x - 1, y - 1, z - 1);
	return res;
}
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);

	while (cin >> a >> b >> c) {
		if (a == -1 && b == -1 && c == -1) return 0;
		cout << "w(" << a << ", " << b << ", " << c << ") = " << w(a, b, c) << "\n";
	}
}