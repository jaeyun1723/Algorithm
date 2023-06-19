#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
#include<map>
using namespace std;

int main() {
	int k;
	cin >> k;
	stack <int> st;
	while (k--)
	{
		int num;
		cin >> num;
		if (num == 0)
			st.pop();
		else
			st.push(num);
	}
	int sum = 0;
	while (!st.empty())
	{
		sum += st.top();
		st.pop();
	}
	cout << sum << '\n';
}