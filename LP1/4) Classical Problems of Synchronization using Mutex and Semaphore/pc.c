#include<stdio.h>
#include<stdlib.h>
#include<sys/types.h>
#include<pthread.h>
#include<unistd.h>
#include<semaphore.h>
#define BUFFER_SIZE 5

sem_t empty;//  for buffer empty
sem_t full;//  for buffer full
pthread_mutex_t mutual;// used for mutual exclusion
int buffer[BUFFER_SIZE];

void *producer(void *arg)
{
    int item,i=0;
    while(1)
    {
        item=rand()%100;
        sem_wait(&empty);
        pthread_mutex_lock(&mutual);
        sleep(1);       
        printf("\n%d item is inserting in buffer at posn %d\n\n",item,i);       
        buffer[i++]=item;
        if(i==BUFFER_SIZE)
 	i=0;	
        pthread_mutex_unlock(&mutual);
        sem_post(&full);
        sleep(1);
    }
}
void *consumer(void *args)
{
    int item,i=0;
    while(1)
    {   sem_wait(&full);
        pthread_mutex_lock(&mutual); 
	sleep(1);      
        item=buffer[i];
        printf("\n%d item is consumed from buffer from position %d\n",item,i);
         i++;
         if(i==BUFFER_SIZE) 
i=0;	     
        pthread_mutex_unlock(&mutual);
        sem_post(&empty);
        sleep(1);
    }
}
int main()
{
    sem_init(&empty,0,BUFFER_SIZE);
    sem_init(&full,0,0);
    pthread_mutex_init(&mutual,NULL);
    pthread_t pid,cid;
    pthread_create(&pid,NULL,producer,NULL);
    pthread_create(&cid,NULL,consumer,NULL);
    pthread_join(pid,NULL);
    pthread_join(cid,NULL);
    return 0;
}


