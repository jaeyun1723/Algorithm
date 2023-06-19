#include<iostream>
#include<string>
using namespace std;
class Node {
public:
	int data;
	Node* next;

	Node(int e) {
		data = e;
		next = NULL;
	}
};

class Stack {
public:
	Node* t;

	Stack() {
		t = NULL;
	}

	int top() {
		if (t == NULL)
			return -1;
		else
			return t->data;
	}

	void push(int x) {
		Node* newNode = new Node(x);
		if (t == NULL)
			t = newNode;
		else
		{
			newNode->next = t;
			t = newNode;
		}
	}

	int pop() {
		if (t == NULL)
			return -1;
		Node* temp = t;
		t = t->next;
		int x = temp->data;
		delete temp;
		return x;
	}

	void BalPartheses(string exp)
	{
		Stack S = Stack();
		char testch;
		int tr = 1;
		for (int i = 0; i < exp.size(); i++)
		{
			testch = exp.at(i);
			if (testch == '[')
				S.push(0);
			else if (testch == '(')
				S.push(1);
			else if (testch == ']')
			{
				if (S.top() == 0)
					S.pop();
				else
				{
					tr = 0;
					break;
				}
			}
			else if (testch == ')')
			{
				if (S.top() == 1)
					S.pop();
				else
				{
					tr = 0;
					break;
				}
			}
		}
		if (tr == 1 && S.top() == -1) cout << "yes" << '\n';
		else cout << "no" << '\n';
	}
};

int main()
{
	Stack S;
	while (1)
	{
		string q;
		getline(cin, q);
		if (q == ".")
			break;
		S.BalPartheses(q);
	}
}
