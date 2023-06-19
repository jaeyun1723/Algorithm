#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
using namespace std;

int main() {
	string s;
	cin >> s;
	s += '=';
	int sum = 0;
	stack <int> st;
	int stsum = 0;
	string num;
	bool minus = false;

	for (int i = 0; i < s.size(); i++)
	{
		if (s[i] >= '0' && s[i] <= '9')
			num += s[i];
		else if (s[i] == '+' || s[i] == '-')
		{
			if (s[i] == '+')
			{
				if (minus == true)
					st.push(stoi(num));
				else
					sum += stoi(num);
			}
			else // '-'
			{
				if (minus == true)
				{
					while (!st.empty())
					{
						stsum += st.top();
						st.pop();
					}
					sum = sum - stsum - stoi(num);
					stsum = 0;
				}
				else
				{
					sum += stoi(num);
					minus = true;
				}
			}
			num = "";
		}
		else
		{
			if (minus == true)
			{
				while (!st.empty())
				{
					stsum += st.top();
					st.pop();
				}
				stsum += stoi(num);
				sum -= stsum;
			}
			else
				sum += stoi(num);
		}
	}
	cout << sum << '\n';
}