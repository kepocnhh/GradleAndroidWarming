# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /home/terrakok-work/android-studio/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


# Enable optimizations
# -optimizations !code/simplification/arithmetic,!code/simplification/cast,!field/*,!class/merging/*
-optimizations !field/*,class/merging/*,code/removal/*,code/simplification/*,class/unboxing/*

-allowaccessmodification
-repackageclasses
-dontpreverify
-android
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses

-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable,InnerClasses,EnclosingMethod
-keepattributes RuntimeVisibleAnnotations
-keepattributes RuntimeInvisibleAnnotations
-keepattributes RuntimeVisibleParameterAnnotations
-keepattributes RuntimeInvisibleParameterAnnotations
-keepattributes Signature
-keepattributes Exceptions




#Play.services
-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}

-keep class * extends java.util.ListResourceBundle {
    protected java.lang.Object[][] getContents();
}


# Json
-dontwarn sun.misc.**
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

#Google gsm
-keep class com.google.android.gms.** { *; }
-dontwarn com.google.android.gms.**



#okhttp 3
-dontwarn okhttp3.internal.platform.*

# Retrofit

-keepclassmembers,allowshrinking,allowobfuscation interface * {
    @retrofit2.http.* <methods>;
}
-dontwarn org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
-dontwarn javax.annotation.**


#Jackson
-keep class com.fasterxml.jackson.databind.ObjectMapper {
    public <methods>;
    protected <methods>;
}
-keep class com.fasterxml.jackson.databind.ObjectWriter {
    public ** writeValueAsString(**);
}
-keepnames class com.fasterxml.jackson.** { *; }
-keepclassmembers class * {
     @com.fasterxml.jackson.annotation.* *;
}
-keep class com.fasterxml.jackson.annotation.** { *; }

-dontwarn com.fasterxml.jackson.databind.**
-keepclassmembers class ru.lsr.android.entity.** { *; }

# for Serializable objects
-keepnames class * implements java.io.Serializable

-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    !static !transient <fields>;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# crashlytics rules
-keep class com.crashlytics.** { *; }
-dontwarn com.crashlytics.**


# Remove the log.* calls
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** w(...);
    public static *** v(...);
    public static *** i(...);
}

# Remove the Toast-messages
-assumenosideeffects class android.widget.Toast{
    public static *** makeText(...);
    public *** show();
}


-keep class .R
-keep class **.R$* {
    <fields>;
}

-keep class org.pjsip.** { *;}

