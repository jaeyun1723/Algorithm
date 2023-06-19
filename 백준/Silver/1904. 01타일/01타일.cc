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

int N;
vector<long long> v;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	cin >> N;
	v.resize(N + 1);
	v[0] = 0, v[1] = 1, v[2] = 2;
	for (int i = 3; i <= N; i++)
		v[i] = (v[i - 1] + v[i - 2]) % 15746;
	cout << v[N] << "\n";
}