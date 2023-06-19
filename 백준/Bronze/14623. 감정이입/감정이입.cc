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

int main() {
	string b1, b2;
	cin >> b1 >> b2;
	long long r1, r2, idx;
	r1 = r2 = idx = 0;
	for (int i = b1.size() - 1; i >= 0; i--) {
		r1 += pow(2, idx) * (b1[i] - '0');
		idx++;
	}
	idx = 0;
	for (int i = b2.size() - 1; i >= 0; i--) {
		r2+= pow(2, idx) * (b2[i] - '0');
		idx++;
	}
	long long res = r1 * r2;
	string ans = "";
	while (res != 0) {
		ans += to_string(res % 2);
		res /= 2;
	}
	for (int i = ans.size() - 1; i >= 0; i--) {
		cout << ans[i];
	}
}