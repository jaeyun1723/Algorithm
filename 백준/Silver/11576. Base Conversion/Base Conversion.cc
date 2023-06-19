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
using namespace std;

int main() {
	int A, B, m;
	cin >> A >> B >> m;
	int var = 0;
	while (m--) {
		int num;
		cin >> num;
		var += pow(A, m) * num;
	}
	vector<int> set;
	while(var!=0) {
		set.push_back(var % B);
		var /= B;
	}
	reverse(set.begin(), set.end());
	for (int i =0; i <set.size(); i++)
		cout << set[i] << " ";
	cout << '\n';
}