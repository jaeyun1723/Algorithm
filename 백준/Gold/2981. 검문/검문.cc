#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
using namespace std;


int GCD(int n1, int n2)
{
	int a = (n1 > n2) ? n1 : n2;
	int b = (a == n2) ? n1 : n2;
	int c;
	while (1)
	{
		c = a % b;
		if (c == 0) break;
		else
		{
			a = b;
			b = c;
		}
	}
	return b;
}

int main() {
	int N;
	cin >> N;
	vector<int> arr;
	arr.resize(N);
	
	for (int i = 0; i < N; i++)
		cin >> arr[i];

	sort(arr.begin(), arr.end());
	int gcd = arr[1] - arr[0];

	for (int i = 2; i < N; i++)
		gcd = GCD(gcd, arr[i] - arr[i - 1]);

	vector <int> v;
	for (int i = 1; i*i<= gcd; i++)
	{
		if (gcd % i == 0)
		{
			v.push_back(i);
			if (gcd / i != i)
				v.push_back(gcd / i);
		}
	}
	sort(v.begin(), v.end());
	
	for (int i = 1; i < v.size(); i++)
		cout << v[i] << " ";
}