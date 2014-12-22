#include<stdio.h>
#include "com_herozhou_mymodule_app2_MainActivity.h"
JNIEXPORT jstring JNICALL Java_com_herozhou_mymodule_app2_MainActivity_hellojni  (JNIEnv * env, jobject obj)
{
    return env->NewStringUTF( "Hello from JNI !  Compiled with ABI .");
}