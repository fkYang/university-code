#include<stdio.h>

void main(){
	unsigned short t = 0x0102 ;
	unsigned char *p=(unsigned char *)&t;
	printf("%d\n",t);
	int test = p[0];
	if(test == 1)
		printf("big\n");
	else if(test == 2)
		printf("small\n");
	else
		printf("%d,%d,no",p[0],p[1]);
	

}
