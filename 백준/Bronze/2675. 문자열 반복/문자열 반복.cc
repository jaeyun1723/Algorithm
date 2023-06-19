#include<iostream>
#include<string>
using namespace std;

int main()
{
	int k;
	cin >> k;
	string a;
	int n;
	while(k--)
	{
		cin >> n >> a;
		for (int i = 0; i < a.size(); i++)
		{
			for (int j = 0; j < n; j++)
			{
				cout << a.at(i);
			}
		}
		cout << '\n';
	}

}
