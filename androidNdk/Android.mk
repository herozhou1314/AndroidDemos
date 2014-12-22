# Copyright (C) 2009 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
#这里明确的说明了LOCAL_PATH的定义必须要放在任何include $(CLEAR_VARS)语句之前
#全文就一个
LOCAL_PATH := $(call my-dir)

#--------Android.mk基本组成--------
#1.LOCAL_PATH 定义了当前模块的相对路径，必须出现在所有的编译模块之前
#2.每个编译模块由include $(CLEAR_VARS) 开始，由include $(BUILD_XXX) 结束
#3.include $(CLEAR_VARS) 是一个编译模块的开始，它会清空除LOCAL_PATH之外的所有LOCA_XXX变量
#4.LOCAL_SRC_FILES 定义了本模块编译使用的源文件，采用的是基于LOCAL_PATH的相对路径
#4.LOCAL_MODULE 定义了本模块的模块名
#6.include $(BUILD_XXX) 描述了编译目标
#--------Android.mk基本组成--------

# first lib, which will be built statically
#

include $(CLEAR_VARS)
#要打印log 必须添加
LOCAL_LDLIBS := -lm -llog
LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
LOCAL_MODULE := LibraryJNI
# 多个 .c 文件 直接空格链接
LOCAL_SRC_FILES :=\
           NDK.c \
           first.c 
#LOCAL_EXPORT_CFLAGS := -LibraryJNI=1
include $(BUILD_SHARED_LIBRARY)

# second lib, which will depend on and include the first one
include $(CLEAR_VARS)
LOCAL_LDLIBS := -lm -llog
LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
LOCAL_MODULE    := LibraryJNI_02
LOCAL_SRC_FILES := objecttoc.c
#LOCAL_STATIC_LIBRARIES := LibraryJNI
LOCAL_CFLAGS := -LibraryJNI_02=2
include $(BUILD_SHARED_LIBRARY)


# thrid lib, which will depend on and include the first one
include $(CLEAR_VARS)
LOCAL_LDLIBS := -lm -llog
LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
LOCAL_MODULE    := LibraryJNI_03
LOCAL_SRC_FILES := business.cpp
#LOCAL_CFLAGS := -LibraryJNI_03=3
include $(BUILD_SHARED_LIBRARY)

# thrid lib, which will depend on and include the first one
include $(CLEAR_VARS)
LOCAL_LDLIBS := -lm -llog
LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
LOCAL_MODULE    := LibraryJNI_04
LOCAL_SRC_FILES := backgroundProcess.cpp
#LOCAL_CFLAGS := -LibraryJNI_04=4
include $(BUILD_SHARED_LIBRARY)
# thrid lib, which will depend on and include the first one
#自定义变量
SUB := sub
#打印
#$(warning  $(SUB))
include $(CLEAR_VARS)
LOCAL_MODULE    := LibraryJNI_05
LOCAL_SRC_FILES := \
    $(SUB)/SubFolder.c
include $(BUILD_SHARED_LIBRARY)

# thrid lib, which will depend on and include the first one
include $(CLEAR_VARS)
LOCAL_LDLIBS := -lm -llog
LOCAL_LDLIBS += -L$(SYSROOT)/usr/lib -llog
LOCAL_MODULE    := LibraryJNI_06
LOCAL_SRC_FILES := JniToJava.cpp
include $(BUILD_SHARED_LIBRARY)
# thrid lib, which will depend on and include the first one

