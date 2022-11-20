
//inclusion of header files
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<pthread.h>
#include<semaphore.h>
int rc=0;               //initialise counter
sem_t mutex,wc;         //declaring semaphore object
void *reader(void *arg) //function defination
{
 int i;
i=(int)arg;
sem_wait(&mutex);       //function call
rc=rc+1;
printf("\nReader %d is waiting ",i);
if(rc==1)
sem_wait(&wc);          //function call
sem_post(&mutex);       //function call
printf("\n Reader %dis in critical sec ",i);
sleep(2);
printf("\nReader %d is exiting",i);
sem_wait(&mutex);       //function call
rc=rc--;
if(rc==0)
sem_post(&wc);          //function call
sem_post(&mutex);       //function call
pthread_exit(NULL);
}
void *writer(void *arg) //function defination
{
sem_wait(&wc);           //function call
printf("\n writer %d is in c.s ",(int *)arg);
sleep(2);
printf("\n writer %d is existing ",(int *)arg);
sem_post(&wc);          //function call
pthread_exit(NULL);
}
int main()
{
int i;
pthread_t th[10];
sem_init(&mutex,0,1);  //initialise semaphore
sem_init(&wc,0,1);    //iniialise semaphore
for(i=0;i<5;i++)
pthread_create(&th[i],NULL,reader,(void*)i);//creating thread
for(i=5;i<10;i++)
pthread_create(&th[i],NULL,writer,(void*)i);//creating thread
pthread_join(th[4],NULL);
pthread_join(th[9],NULL);
pthread_join(th[3],NULL);
pthread_join(th[0],NULL);
pthread_join(th[5],NULL);
pthread_join(th[6],NULL);
pthread_join(th[7],NULL);
pthread_join(th[2],NULL);
pthread_join(th[8],NULL);
pthread_join(th[1],NULL);
return(0);
}


