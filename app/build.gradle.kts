plugins {
    applyAll(
        Plugin.androidApplication,
        Plugin.kotlinAndroid
    )
}

fun getOutputFileName(
    productFlavor: com.android.builder.model.ProductFlavor,
    buildType: com.android.build.gradle.internal.dsl.BuildType
): String {
    return productFlavor.applicationId + buildType.applicationIdSuffix +
        "-" + productFlavor.versionName + buildType.versionNameSuffix +
        "-" + productFlavor.versionCode +
        ".apk"
}

android {
    compileSdkVersion(Version.Android.compileSdk)
    buildToolsVersion = Version.Android.buildTools

    defaultConfig {
        minSdkVersion(Version.Android.minSdk)
        targetSdkVersion(Version.Android.targetSdk)
        applicationId = Common.applicationId
        versionCode = Version.Application.code
        versionName = Version.Application.name
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isShrinkResources = false
            applicationIdSuffix = ".$name"
            versionNameSuffix = "-$name"
            manifestPlaceholders["appNameSuffix"] = " $name"
        }
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            applicationIdSuffix = ""
            versionNameSuffix = ""
            manifestPlaceholders["appNameSuffix"] = ""
        }
    }

    applicationVariants.all {
        val outputFileName = getOutputFileName(
            defaultConfig,
            buildType = buildTypes.getByName(name)
        )
        outputs.forEach { output ->
            check(output is com.android.build.gradle.internal.api.ApkVariantOutputImpl)
            output.outputFileName = outputFileName
        }
    }
}

dependencies {
    implementation(Dependency.kotlinStdlib)
}
