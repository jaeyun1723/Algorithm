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

int N, C, Max;
vector<int> v;
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> C;
	v.resize(N);
	for (int i = 0; i < N; i++)
		cin >> v[i];
	sort(v.begin(), v.end());
	int Left = 1, Right = v[N - 1] - v[0];
	while (Left <= Right) {
		int mid = (Left + Right) / 2;
		int prev = v[0], cnt = 1;
		for (int i = 1; i < N; i++)
			if (v[i] - prev >= mid) {
				cnt++;
				prev = v[i];
			}
		if (cnt >= C) {
			Max = (mid > Max) ? mid : Max;
			Left = mid + 1;
		}
		else
			Right = mid - 1;
	}
	cout << Max << '\n';
}