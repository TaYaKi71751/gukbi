#include<stdio.h>
// https://en.wikipedia.org/wiki/XOR_swap_algorithm
int main(){
	char *a = "a";
	char *b = "b";
	a = (char*)((size_t)a ^ (size_t)b);
	b = (char*)((size_t)b ^ (size_t)a);
	a = (char*)((size_t)a ^ (size_t)b);
	printf("%s\n",a);
	printf("%s\n",b);
}
