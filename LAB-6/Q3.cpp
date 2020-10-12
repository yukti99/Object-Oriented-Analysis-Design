#include <iostream>
#include <malloc.h>
using namespace std;

int main(){
	int *a,*b;
	a = (int*)malloc(sizeof(int));
	b = (int*)malloc(5*sizeof(int));
	cout<<sizeof(int)<<" "<<5*sizeof(int)<<endl;
	cout<<sizeof(a)<<endl;
	cout<<sizeof(a)<<" "<<sizeof(b)<<endl;
	return 0;
}