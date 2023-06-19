#include<iostream>
#include<vector>
using namespace std;

class Node {
public:
	char data;
	Node* left;
	Node* right;

	Node(char x)
	{
		data = x;
		left = right = NULL;
	}
};

class Tree {
public:
	Node* root;

	Tree(char x) {
		root = new Node(x);
	}

	void Insert(char x, char y, Node* cur)
	{
		if (cur->data == x)
		{
			if (cur->left == NULL)
				cur->left = new Node(y);
			else
				cur->right = new Node(y);
		}
		else
		{
			if (cur->left != NULL) 
				Insert(x, y, cur->left);
			if (cur->right != NULL) 
				Insert(x, y, cur->right);
		}
	}

	void PreOrder(Node* cur)
	{
		Node* temp = cur;
		if (temp->data != '.')
			cout << temp->data;
		if (temp->left != NULL) 
			PreOrder(temp->left);
		if (temp->right != NULL)
			PreOrder(temp->right);
	}

	void InOrder(Node* cur)
	{
		Node* temp = cur;
		if (temp->left != NULL)
			InOrder(temp->left);
		if (temp->data != '.')
		cout << temp->data;
		if (temp->right != NULL)
			InOrder(temp->right);
	}
	
	void PostOrder(Node* cur)
	{
		Node* temp = cur;
		if (temp->left != NULL)
			PostOrder(temp->left);
		if (temp->right != NULL)
			PostOrder(temp->right);
		if (temp->data != '.')
		cout << temp->data;
	}
};

int main() {
	Tree T('A');
	int N;
	cin >> N;
	for (int i = 0; i < N; i++)
	{
		char P, L, R;
		cin >> P >> L >> R;
	//	if (L != '.')
			T.Insert(P, L, T.root);
	//	if (R != '.')
			T.Insert(P, R, T.root);
	}
	T.PreOrder(T.root);
	cout << '\n';
	T.InOrder(T.root);
	cout << '\n';
	T.PostOrder(T.root);
}