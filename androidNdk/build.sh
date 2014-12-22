#!/bin/sh
javah -classpath .:../bin/classes:$ANDROID_SDK/platforms/android-8/android.jar -d ../jni -jni $1