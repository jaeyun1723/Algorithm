#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
using namespace std;

int main() {
	int N;
	cin >> N;
	vector<int> v;
	v.resize(N);

	for (int i = 0; i < N; i++)
		cin >> v[i];

	sort(v.begin(), v.end());

	for (int i = 1; i < N; i++)
		v[i] += v[i - 1];

	int sum = 0;
	for (int i = 0; i < N; i++)
		sum += v[i];
	cout << sum << '\n';
}