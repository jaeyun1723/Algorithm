#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
using namespace std;

int main() {
	int N, K;
	cin >> N >> K;
	
	int num = 1;
	int den = 1;
	while (K!=0)
	{
		num *= N;
		N--;
		den *= K;
		K--;
	}

	cout << num / den << '\n';

}