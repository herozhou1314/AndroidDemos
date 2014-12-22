/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
#include <string.h>
#include "business.h"
#include "LogCat.h"
#define JNIPAR_CLASS "com/hero/org/models/Order"
/*
 * Class:     com_hero_org_util_Business
 * Method:    getPrice
 * Signature: (Ljava/lang/String;)D
 */
jobject getInstance(JNIEnv* env, jclass obj_class);
JNIEXPORT jdouble JNICALL Java_com_hero_org_util_Business_getPrice(JNIEnv* env, jobject obj, jstring name) {
	const char* pname = env->GetStringUTFChars(name, NULL);
	LOGE("Before release:  %s", pname);
	if (strcmp(pname, "Apple") == 0) {
		env->ReleaseStringUTFChars(name, pname);
		LOGE("After release:  %s", pname);
		return 1.2;
	} else {
		env->ReleaseStringUTFChars(name, pname);
		LOGE("After release:  %s", pname);
		return 2.1;
	}
}

/*
 * Class:     com_hero_org_util_Business
 * Method:    getOrder
 * Signature: (Ljava/lang/String;I)Lcom/hero/org/util/Order;
 */
JNIEXPORT jobject JNICALL Java_com_hero_org_util_Business_getOrder(JNIEnv* env, jobject obj, jstring name, jint amount) {
	jclass order_class = env->FindClass(JNIPAR_CLASS);
	jobject order = getInstance(env, order_class);
	jmethodID setName_method = env->GetMethodID(order_class, "setName", "(Ljava/lang/String;)V");
	env->CallVoidMethod(order, setName_method, name);
	jmethodID setAmount_method = env->GetMethodID(order_class, "setAmount", "(I)V");
	env->CallVoidMethod(order, setAmount_method, amount);
	return order;
}

/*
 * Class:     com_hero_org_util_Business
 * Method:    getRamdomOrder
 * Signature: ()Lcom/hero/org/util/Order;
 */
JNIEXPORT jobject JNICALL Java_com_hero_org_util_Business_getRamdomOrder(JNIEnv* env, jobject obj) {
	jclass business_class = env->GetObjectClass(obj);
	jobject business_obj = getInstance(env, business_class);
	jmethodID notification_method = env->GetMethodID(business_class, "notification", "()V");
	env->CallVoidMethod(obj, notification_method);
	jclass order_class = env->FindClass(JNIPAR_CLASS);
	jobject order = getInstance(env, order_class);
	jfieldID amount_field = env->GetFieldID(order_class, "amount", "I");
	jint amount = env->GetIntField(order, amount_field);
	LOGE("amount: %d", amount);
	return order;

}
/*
 * Class:     com_hero_org_util_Business
 * Method:    analyzeOrder
 * Signature: (Lcom/hero/org/util/Order;)V
 */
JNIEXPORT jint JNICALL Java_com_hero_org_util_Business_pullOrder(JNIEnv* env, jobject cls, jobject obj) {
	//jclass order_class = env->GetObjectClass(obj);
	jclass order_class = env->FindClass(JNIPAR_CLASS);
	jmethodID getName_method = env->GetMethodID(order_class, "getName", "()Ljava/lang/String;");
	jstring name_str = static_cast<jstring>(env->CallObjectMethod(obj, getName_method));
	const char* pname = env->GetStringUTFChars(name_str, NULL);
	LOGE("Name in pullOrder:  %s", pname);
	jclass order_class_ = env->GetObjectClass(cls);
	jmethodID notification_method_static = env->GetStaticMethodID(order_class_, "notificationByStatic", "()V");
	env->CallStaticVoidMethod(order_class_, notification_method_static);
}

JNIEXPORT void JNICALL Java_com_hero_org_util_Business_analyzeOrder(JNIEnv *env, jobject cls, jobject obj ) {
	/***这里很重要从java传递object到 jni 首先获取 与之对应的 jclass*/
	jclass order_class = env->FindClass(JNIPAR_CLASS);
	jmethodID getName_method = env->GetMethodID(order_class, "getName", "()Ljava/lang/String;");
	jstring name_str = static_cast<jstring>(env->CallObjectMethod(obj, getName_method));
	const char* pname = env->GetStringUTFChars(name_str, NULL);
	LOGE("Name in analyzeOrder:  %s", pname);
	/***GetObjectClass()  函数是对获取 native 方法所在 class的对应*/
    jclass _class = env->GetObjectClass(cls);
    jmethodID notification_method_static = env->GetStaticMethodID(_class, "notificationByStatic", "()V");
    env->CallStaticVoidMethod(_class, notification_method_static);
}
jobject getInstance(JNIEnv* env, jclass obj_class) {
jmethodID construction_id = env->GetMethodID(obj_class, "<init>", "()V");
jobject obj = env->NewObject(obj_class, construction_id);
return obj;
}

