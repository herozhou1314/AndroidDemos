#include <string.h>
#include <jni.h>
#include "first.h"
#include "LogCat.h"
#include "NDK.h"
#include <stdio.h>
#define JNIPAR_CLASS "com/hero/org/models/Person"

JNIEXPORT jstring JNICALL Java_com_hero_org_util_NDK_getString(JNIEnv *env, jclass obj) {
	jstring str = (*env)->NewStringUTF(env, "Hello from JNI !");
	return str;
}
JNIEXPORT jint JNICALL Java_com_hero_org_util_NDK_add(JNIEnv* env, jobject this, jint x, jint y) {
	return first(x, y);
}
JNIEXPORT void JNICALL Java_com_hero_org_util_NDK_push(JNIEnv *env, jobject thiz, jobject obj) {
	LOGE("%s", "我要看到的调试信息^_^");
	jclass student_cls = (*env)->FindClass(env, JNIPAR_CLASS);
	if (student_cls == NULL)
		return; //can not find class Studnet
	jmethodID getName = (*env)->GetMethodID(env, student_cls, "getName", "()Ljava/lang/String;");
	LOGE("%s", "getName == NULL");
	if (getName == NULL)
		return;
	jmethodID setName = (*env)->GetMethodID(env, student_cls, "setName", "(Ljava/lang/String;)V");
	if (setName == NULL)
		return;
	jmethodID getHeight = (*env)->GetMethodID(env, student_cls, "getHeight", "()F");
	if (getHeight == NULL)
		return;
	jmethodID getAge = (*env)->GetMethodID(env, student_cls, "getAge", "()I");
	if (getAge == NULL)
		return;
	jmethodID printInfo = (*env)->GetMethodID(env, student_cls, "toString", "()Ljava/lang/String;");
	jobject mStudent = obj;
	LOGE("%s", "mStudent == NULL");
	if (mStudent == NULL)
		return;
	jstring jname_str = NULL;
	LOGE("%s", "我要看到的调试信息^_^");
	char* cname_str = NULL;
	jname_str = (*env)->CallObjectMethod(env, mStudent, getName);
	cname_str = (char*) (*env)->GetStringUTFChars(env, jname_str, 0);
	jint jnum = (*env)->CallIntMethod(env, mStudent, getAge);
	jfloat jHeight = (*env)->CallFloatMethod(env, mStudent, getHeight);
	LOGE("%s", cname_str);
	LOGE("%d", jnum);
	LOGE("%f", jHeight);
	/**通过JNI函数GetObjectClass得到传入对象的类信息。
	 *这里传入的对象，就是调用Native方法的那个对象 (这里指NDK.java)
	 *这里传入的对象，就是调用Native方法的那个对象 */
	jclass jcls = (*env)->GetObjectClass(env, thiz);
	//根据类信息得到callback方法的jmethodID
	jmethodID jmId = (*env)->GetMethodID(env, jcls, "callback", "()V");
	//调用callback方法
	(*env)->CallVoidMethod(env, thiz, jmId);
	/*因为在Java层的callback中抛出了未捕获的异常，所以上面的JNI函数调用必然
	 *出现异常，这里必须检查并处理异常，否则异常将抛给Java层的callback方法
	 *而此时Java层callback也没有捕获异常，此时，进程将死掉*/
	jclass clazz;
	clazz = (*env)->GetObjectClass(env, obj); //通过类的对象
	//jstring jstr = (*env)->GetObjectField(env, obj, java_method);
	if ((*env)->ExceptionCheck(env)) {
		(*env)->ExceptionDescribe(env);
		(*env)->ExceptionClear(env); //清除异常
	}
}
/*
 * We use inlined functions for C++ so that programmers can write:
 *
 *   env->FindClass("java/lang/String")
 *
 * in C++ rather than:
 *
 *    (*env)->FindClass(env, "java/lang/String")
 *
 * in C.
 */

jobject getInstance(JNIEnv* env, jclass obj_class) {
	jmethodID construction_id = (*env)->GetMethodID(env, obj_class, "<init>", "()V");
	jobject obj = (*env)->NewObject(env, obj_class, construction_id);
	return obj;
}
JNIEXPORT jobject JNICALL Java_com_hero_org_util_NDK_fetch(JNIEnv *env, jobject obj) {
	jclass java_class = (*env)->FindClass(env, JNIPAR_CLASS);
	if (java_class == NULL) {
		LOGE("%s", "not find class!");
		return NULL; //如果方法ID没有找到
	}
	jobject java_obj = getInstance(env, java_class);
	if (java_obj == NULL) {
		LOGE("%s", "not find java OBJ!");
		return NULL; //如果方法ID没有找到
	}
	jmethodID getName = (*env)->GetMethodID(env, java_class, "getName", "()Ljava/lang/String;");
	if (getName == NULL) {
		LOGE("%s", "not find  java method!");
		return NULL; //如果方法ID没有找到
	}
	jstring jstr = (*env)->CallObjectMethod(env, java_obj, getName);
	char *str = (char*) (*env)->GetStringUTFChars(env, jstr, 0);
	if (jstr == NULL) {
		LOGE("%s", "not find java method!");
	} else {
		LOGE("%s", " find java method!");
		LOGE("%s", str);
	}
	return java_obj;
}

typedef struct {
	unsigned char TermId[8];
	unsigned char TerminalType;
	unsigned long MerchNum;
} EMV_PARAM;

