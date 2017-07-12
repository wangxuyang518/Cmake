
#项目的文件路径,后续路径都是相对于这个路径
set(Project F:/workspace/Cmake)
cmake_minimum_required(VERSION 3.4.1)

#引用第三方库的格式
add_library(crypto  SHARED  IMPORTED)
add_library(ssl  SHARED  IMPORTED)

#设置第三方so的文件路径  ${ANDROID_ABI}代表“armeabi”,"x86"的统称
set_target_properties(crypto PROPERTIES IMPORTED_LOCATION
                      ${Project}/app/libs/${ANDROID_ABI}/libcrypto.so)

set_target_properties(ssl PROPERTIES IMPORTED_LOCATION
                      ${Project}/app/libs/${ANDROID_ABI}/libssl.so)

#引入第三方so的头文件
include_directories( ${Project}/app/src/main/jni/include )

#引入自己编写的c文件代码。多个的话就有多个add_library
add_library(md5  SHARED  src/main/jni/testmd.c)

find_library(log-lib  log )

#连接第三方库
target_link_libraries(md5 crypto  ssl  ${log-lib} )