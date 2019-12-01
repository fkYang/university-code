#include<stdio.h>

void main()
{
	struct ipv4_header {
	unsigned char ver_ihl;          //版本 (4 bits) + 首部长度 (4 bits)
	unsigned char tos;             //服务类型
	unsigned short tlen;            //数据报总长度
	unsigned short identification;    //标识
	unsigned short flags_fo;        //标志 (3 bits) + 片偏移 (13 bits)
        unsigned char ttl;             //生存时间
	unsigned char proto;           //协议
	unsigned short crc;            //首部校验和
	unsigned int ip_src;              //源IP地址
	unsigned int ip_dst;              //目的IP地址
    } temp;
	printf("%ld\n",sizeof(temp));
	temp.ver_ihl =0x45 ;
	temp.tos =0x00 ;
	temp.tlen =0x0028 ;
	temp.identification =0x59fb ;
	temp.flags_fo =0x4000 ;
	temp.ttl =0x32;
	temp.proto =0x06 ;
	temp.crc =0x1234 ;
	temp.ip_src = 0x7709ee40;
	temp.ip_dst = 0x0a060204;
	
	int nums[10] = {1,1,2,2,2,1,1,2,4,4};
	unsigned char *n = (unsigned char *)&temp;
	for(int i = 0 ; i < 20 ; i++)
		printf("%x ",n[i]);
	printf("\n");
	
	int size = 0;
	for(int i = 0 ; i < 10; i++)
	{
		switch(nums[i]){
		case 1:
			printf("%0x ",*(n+size));
			break;
		case 2:
			printf("%0x ",n[size+1]);
			printf("%0x ",n[size]);
			break;
		case 4:
			for(int j = 3 ; j >=0 ; j--)
				printf("%0x ",n[size+j]);
			break;
		default:
			break;
		}

		size += nums[i];
	}
	printf("\n");

}
