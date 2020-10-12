#include <iostream>
#include <malloc.h>
using namespace std;

int main(){
	float *a;
	a = (float*)malloc(sizeof(int));
	a[0] = 4.5;
	cout<<a[0];
	return 0;
}