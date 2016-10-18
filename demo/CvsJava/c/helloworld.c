#include<iostream.h>
#include<conio.h>


struct Employee{
char name[20];
int id;

}

void main(){

struct Employee e*;
accept(e);
display(e);
//acceptAll(5,e);
//displayAll(5,e)
free(e);
}

void accept(Employee e*){
e=(Employee*)malloc(sizeof(Employee));
printf("Enter Name\n");
scanf(%s,e.name);
printf("Enter id\n");
scanf("%d",&e.id);
}

void accept2(Employee e*)
{

void *ptr=malloc(sizeof(Employee));
e=(Employee*)ptr;
printf("Enter Name\n");
scanf(%s,(*e).name);
printf("Enter id\n");
scanf("%d",(*e).id);

char *a;
a=(char*)ptr;
for(int i=0;i<4;i++)
  scanf(%c,(*a+i));

free(ptr);
}


void acceptAll(int n, Employee e*){
e=(Employee*)malloc(n*sizeof(Employee));
for(int i=0;i<n;i++){
printf("Enter Name\n");
scanf(%s,(*e+i).name);
printf("Enter id\n");
scanf("%d",&(*e+i).id);
}

}


void display(struct emp){
printf("Name=%s, id=%d",emp.name,emp.id);
}

void displayAll(int n,Employee emp*){
for(int i=0;i<n;i++){
printf("Name=%s, id=%d",(emp+i).name,(emp+i).id);
}

}



 