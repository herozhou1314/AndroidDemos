#!/bin/sh
export ProjectPath=$(cd "../$(dirname "$1")"; pwd)
#要生成的头文件
export TargetClassName="com.herozhou.mymodule.app2.MainActivity"
# MyJNILibrary is the module name
export SourceFile="${ProjectPath}/MyJNILibrary/src/main/java"
export TargetPath="${ProjectPath}/MyJNILibrary/src/main/jni"
#/com/herozhou/mymodule/app2
cd "${SourceFile}"
javah -d ${TargetPath} -classpath "${SourceFile}" "${TargetClassName}"
echo -d ${TargetPath} -classpath "${SourceFile}" "${TargetClassName}"
