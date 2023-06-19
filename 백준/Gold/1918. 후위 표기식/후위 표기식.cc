#include<iostream>
#include<string>
using namespace std;

class Stack {
public:
	int t;
	char* S;

	Stack(char N) {
		S = new char[N];
		t = -1;
	}

	int size() {
		return t + 1;
	}

	char top() {
		return S[t];
	}

	void push(char x)
	{
		S[++t] = x;
	}

	char pop()
	{
		if (size() == 0)
			return 0;
		else
		{
			t--;
			return S[t + 1];
		}
	}

	void calpostfix(string exp)
	{
		Stack A = Stack(105);
		string result = "";
		char testch;
		char k;
		for (int i = 0; i < exp.size(); i++)
		{
			testch = exp.at(i);
			if (testch == '+' || testch == '-') {
				while (A.size() != 0 && A.top() != '(') {
					k = A.pop();
					result += k;
				}
				A.push(testch);
			}
			else if (testch == '*' || testch == '/') {
				while (A.top() == '*' || A.top() == '/') {
					k = A.pop();
					result += k;
				}
				A.push(testch);
			}
			else if (testch == '(')
				A.push('(');
			else if (testch == ')')
			{
				while (A.top() != '(')
				{
					k = A.pop();
					result += k;
				}
				A.pop();
			}
			else
				result += testch;
		}

			//if (testch == '+'||testch=='-')
			//{
			//	if (A.top() == '*' || A.top() == '/')
			//	{
			//		while (A.top() == '*' || A.top() == '/')
			//		{
			//			k = A.pop();
			//			result += k;
			//		}
			//		A.push(testch);
			//	}
			//	else if (A.size() != 0 && A.top() != '(')
			//	{
			//		k = A.pop();
			//		result += k;
			//		A.push(testch);
			//	}
			//	else
			//		A.push(testch);
			//}
			//else if (testch == '*' || testch == '/')
			//{
			//	if (A.top() == '*' || A.top() == '/')
			//	{
			//		k = A.pop();
			//		result += k;
			//		A.push(testch);
			//	}
			//	else
			//		A.push(testch);
			//}
			//else if (testch == '(')
			//	A.push('(');
			//else if (testch == ')')
			//{

			//	while (A.top() != '(')
			//	{
			//		k = A.pop();
			//		result += k;
			//	}
			//	A.pop();
			//}
			//else
			//	result += testch;

		//}
		while (A.size() != 0)
		{
			char m = A.pop();
			result += m;
		}
		cout << result << '\n';
	}
};

int main() {
	Stack S(105);
	string exp;
	cin >> exp;
	S.calpostfix(exp);
}

//(A+(B*C))-(D/E)