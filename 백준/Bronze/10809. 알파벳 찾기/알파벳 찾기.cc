#include<iostream>
#include<string>
using namespace std;

int main()
{
	string a;
	cin >> a;
	int arr[26];
	for (int i = 0; i < 26; i++)
	{
		arr[i] = -1;
	}
	for (int i = 0; i < a.size(); i++)
	{
		if(arr[int(a.at(i)) - 97] == -1)
		arr[int(a.at(i)) - 97] = i;
	}
	for (int i = 0; i < 26; i++)
	{
		cout << arr[i] << " ";
	}
}