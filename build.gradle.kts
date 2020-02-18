buildscript {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://maven.fabric.io/public")
        }
    }

    dependencies {
        classpathAll(
            Dependency.androidToolsBuildGradle,
            Dependency.fabricToolsGradle,
            Dependency.googleMobileServices,
            Dependency.kotlinGradlePlugin
        )
    }
}

task<Delete>("clean") {
    delete = setOf(rootProject.buildDir)
}

allprojects {
    repositories {
        google()
        jcenter()
        maven {
            setUrl("https://jitpack.io")
        }
    }
}
