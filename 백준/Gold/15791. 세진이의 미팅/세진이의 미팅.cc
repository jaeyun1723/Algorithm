#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
#include<deque>
#include<list>
using namespace std;


typedef long long ll;
ll mod = 1000000007;

ll func(ll a, ll b) {
	if (!b) return 1;
	if (b & 1) return (a * func(a, b - 1) % mod) % mod;
	return func((a * a) % mod, b / 2) % mod;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	ll N, M;
	cin >> N >> M;
	ll n = 1, r = 1, idx = 1, diff = 1;
	//for (ll i = 1; i <= N; i++) {
	//	n *= i;
	//	n %= mod;
	//}
	//for (ll i = 1; i <= M; i++) {
	//	n *= i;
	//	n %= mod;
	//}
	//for (ll i = 1; i <= N-M; i++) {
	//	diff *= i;
	//	diff %= mod;
	//}
	while (1) {
		if (N >= idx) {
			n *= idx;
			n %= mod;
		}
		if (M >= idx) {
			r *= idx;
			r %= mod;
		}
		if (N - M >= idx) {
			diff *= idx;
			diff %= mod;
		}
		idx++;
		if (N < idx && M < idx && N - M < idx) break;
	}

	ll cnt = func((r * diff) % mod, mod - 2);
	cout << (n * cnt) % mod << '\n';
}