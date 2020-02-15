buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpathAll(
            Dependency.androidToolsBuildGradle,
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
