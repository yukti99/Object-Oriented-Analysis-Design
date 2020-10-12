#include <iostream>
#include <malloc.h>
using namespace std;

int main(){
	int *a[5];
	cout<<sizeof(int)<<endl;
	a[0] = (int*)malloc(2*sizeof(int));
	a[0][1] = 5;
	cout<<a[0][1]<<endl;
	return 0;
}