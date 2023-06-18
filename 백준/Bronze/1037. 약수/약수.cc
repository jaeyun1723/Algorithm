#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
using namespace std;

int main() {
	int N;
	cin >> N;
	vector<int> v;
	v.resize(N);
	for (int i = 0; i < N; i++)
		cin >> v[i];
	sort(v.begin(), v.end());

	cout << v[0] * v[N - 1] << '\n';
}