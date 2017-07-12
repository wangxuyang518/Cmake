//
// Created by wxy on 2017/7/11.
//

#include <jni.h>
#include <string.h>
#include <openssl/md5.h>
#include <stdio.h>


JNIEXPORT jstring JNICALL
Java_xinyi_com_cmake_MD5Activity_m5EnCode(JNIEnv *env, jobject instance, jstring c_) {
    const char *data = (*env)->GetStringUTFChars(env, c_, 0);
    MD5_CTX ctx;
    unsigned char md[16];
    char buf[33]={'/0'};
    char tmp[3]={'/0'};
    int i;
    MD5_Init(&ctx);
    MD5_Update(&ctx,data,strlen(data));
    MD5_Final(md,&ctx);
    for( i=0; i<16; i++ ){
        sprintf(tmp,"%02X",md[i]);
        strcat(buf,tmp);
    }
    char *dest_str; // 目标字符串
    dest_str = (char *)malloc(sizeof(char) * (sizeof(buf) + 1));
    strncpy(dest_str, buf, sizeof(buf));
    return (*env)->NewStringUTF(env,dest_str);
}


JNIEXPORT jstring JNICALL
Java_xinyi_com_cmake_MD5Activity_m5DeCode(JNIEnv *env, jobject instance, jstring c_) {
    const char *c = (*env)->GetStringUTFChars(env, c_, 0);

    // TODO

    (*env)->ReleaseStringUTFChars(env, c_, c);

    return (*env)->NewStringUTF(env, "");
}
