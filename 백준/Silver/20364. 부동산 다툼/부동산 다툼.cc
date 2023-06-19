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
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n, q;
	cin >> n >> q;
	vector<bool> land(n + 1, 0);
	while (q--) {
		int num;
		cin >> num;
		bool flag = false;
		int res = num;
		int first;
		while (res != 1) {
			if (land[res] == true) {
				flag = true;
				first = res;
			}
			res /= 2;
		}
		if (flag)
			cout << first << '\n';
		else {
			cout << 0 << '\n';
			land[num] = true;
		}
	}
}