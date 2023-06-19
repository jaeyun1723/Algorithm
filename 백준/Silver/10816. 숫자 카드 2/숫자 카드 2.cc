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

vector<int> v;
int N, M;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	v.resize(N);
	for (int i = 0; i < N; i++) {
		cin >> v[i];
	}
	cin >> M;
	sort(v.begin(), v.end());
	while (M--) {
		int num;
		cin >> num;
		vector<int>::iterator low = lower_bound(v.begin(), v.end(), num), up = upper_bound(v.begin(), v.end(), num);
		cout << up - low << " ";
	}
}