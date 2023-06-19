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
int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	int N, M;
	cin >> N;
	int sz = N;
	while (sz--) {
		int num;
		cin >> num;
		v.push_back(num);
	}
	sort(v.begin(), v.end());
	cin >> M;
	while (M--) {
		int src;	
		cin >> src;
		vector<int>::iterator it = lower_bound(v.begin(), v.end(), src);
		if (it == v.end()||*it!=src) cout << 0 << '\n';
		else cout << 1 << '\n';
	}
}