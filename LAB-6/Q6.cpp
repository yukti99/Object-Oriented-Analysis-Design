#include <iostream>
#include <malloc.h>
using namespace std;

int main(){
	int b[10];
	cout<<sizeof(b)<<endl;
	struct node{
		int a[10];
	};
	struct node *n;
	cout<<sizeof(struct node*)<<endl;
	n = (struct node*)malloc(sizeof(struct node));
	cout<<sizeof(n)<<endl;
	return 0;
}