#include<iostream>
using namespace std;

int main() {
	int k, i, j, a;
	cin >> k;

	for (i = 0; i < k; i++) 
	{
		for (a = i; a < k-1; a++)
			cout << " ";
		for (j = 0; j < i + 1; j++)
			cout << "*";
		cout << '\n';
	}
}