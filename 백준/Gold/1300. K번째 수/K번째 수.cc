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

int N, k;
vector<int> v;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> k;
	int ans, left = 1, right = k; // k번째 수는 k보다 작다
	while (left <= right) {
		int mid = (left + right) / 2;
		long long cnt = 0;
		for (int i = 1; i <= N; i++)
			cnt += min(mid / i, N);
		if (cnt < k) left = mid + 1;
		else
		{
			ans = mid;
			right = mid - 1;
		}
	}
	cout << ans << '\n';
}