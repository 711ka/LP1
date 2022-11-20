#include <jni.h>
#include <stdio.h>
#include "B1.h"
JNIEXPORT int JNICALL Java_B1_add(JNIEnv *env, jobject obj, jint a, jint b)
{
printf("\n%d + %d = %d\n",a,b,(a+b));
return;
}
JNIEXPORT int JNICALL Java_B1_sub(JNIEnv *env, jobject obj, jint a, jint b)
{
printf("\n%d - %d = %d\n",a,b,(a-b));
return;
}
JNIEXPORT int JNICALL Java_B1_mult(JNIEnv *env, jobject obj, jint a, jint b)
{
printf("\n%d * %d = %d\n",a,b,(a*b));
return;
}
JNIEXPORT int JNICALL Java_B1_div(JNIEnv *env, jobject obj, jint a, jint b)
{
printf("\n%d / %d = %d\n",a,b,(a/b));
return;
}
/*Exeution Steps:
$ javac B1.java
javah -classpath . B1
$ ls
B1.c B1.c~ B1.class B1.h B1.java
$ gcc -shared -fPIC -I/usr/lib/jvm/default-java/include -I/usr/lib/jvm/default-java/include/linux B1.c -o libB1.so
$ ls
B1.c B1.c~ B1.class B1.h B1.java libB1.so
$ java -classpath . -Djava.library.path=. B1
*/