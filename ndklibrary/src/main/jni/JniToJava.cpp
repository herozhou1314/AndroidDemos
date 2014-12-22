/*
 * JniToJava_getPerson.cpp
 *
 *  Created on: 2013年8月16日
 *      Author: herozhou1314
 */
#include "JniToJava.h"
#include <jni.h>
#include <string.h>
#include "LogCat.h"
#define JNIPAR_CLASS "com/hero/org/models/Person"
// jfieldID结构体，用于保存类“Person.java”的filedID
struct PersonOffsets {
	jfieldID name;
	jfieldID age;
	jfieldID height;
} gPersonOffsets;

// 与“Person.java”对应的结构体，用于保存数据，并将数据赋值给Person.java的成员
typedef struct tagPerson {
	char mName[10];
	int mAge;
	float mHeight;
} Person;

jobject getInstance01(JNIEnv* env, jclass obj_class) {
	jmethodID construction_id = env->GetMethodID(obj_class, "<init>", "()V");
	jobject obj = env->NewObject(obj_class, construction_id);
	return obj;
}
JNIEXPORT jobject JNICALL Java_com_hero_org_JniToJava_getPerson(JNIEnv *env, jobject jobj) {
	jclass obj_class = env->FindClass(JNIPAR_CLASS);
	jobject jaz_cls = getInstance01(env, obj_class);
	if (jaz_cls == NULL)
		return NULL;
	jmethodID setName = env->GetMethodID(obj_class, "setName", "(Ljava/lang/String;)V");
	if (setName == NULL)
		return NULL;
	jmethodID getHeight = env->GetMethodID(obj_class, "getHeight", "()F");
	if (getHeight == NULL)
		return NULL;
	jmethodID setAge = env->GetMethodID(obj_class, "setAge", "(I)V");
	if (setAge == NULL)
		return NULL;
	jmethodID setHeight = env->GetMethodID(obj_class, "setHeight", "(F)V");
	if (setHeight == NULL)
		return NULL;
	jobject person = jaz_cls;
	if (person == NULL)
		return NULL;
	jstring jname_string = env->NewStringUTF("herozhou1314");
	env->CallVoidMethod(person, setName, jname_string);
	env->CallVoidMethod(person, setAge, 25);
	env->CallVoidMethod(person, setHeight, 165.0);
	jfloat jf = env->CallFloatMethod(person, getHeight);
	LOGE("getheight-->>%f", jf);
	//清除指针
	env->DeleteLocalRef(jname_string);
	return person;

}

