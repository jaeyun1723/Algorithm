#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<stack>
#include<queue>
using namespace std;

int main() {
	int A, B;
	cin >> A >> B;

	int MIN = (A < B) ? A : B;

	int GCD,LCM;
	GCD = 1;

	for (int i = 2; i <= MIN ; i++)
	{
		if (A % i == 0 && B % i == 0)
			GCD = i;
	}

	LCM = GCD * (A / GCD) * (B / GCD);

	cout << GCD << '\n' << LCM << '\n';
}