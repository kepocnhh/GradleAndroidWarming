private const val androidGroup = "com.android"
private const val jetbrainsGroup = "org.jetbrains"
private const val kotlinGroup = "$jetbrainsGroup.kotlin"

object Common {
    const val applicationId = "gradle.android.warming"
}

data class Dependency(
    val group: String,
    val name: String,
    val version: String
) {
    companion object {
        val androidToolsBuildGradle = Dependency(
            group = "$androidGroup.tools.build",
            name = "gradle",
            version = Version.Android.toolsBuildGradle
        )

        val kotlinGradlePlugin = Dependency(
            group = kotlinGroup,
            name = "kotlin-gradle-plugin",
            version = Version.kotlin
        )
        val kotlinStdlib = Dependency(
            group = kotlinGroup,
            name = "kotlin-stdlib",
            version = Version.kotlin
        )
    }
}

data class Plugin(
    val name: String,
    val version: String
) {
    companion object {
        val androidApplication = Plugin(
            name = "$androidGroup.application",
            version = ""
        )

        val androidLibrary = Plugin(
            name = "$androidGroup.library",
            version = ""
        )

        val kotlinJvm = Plugin(
            name = "$kotlinGroup.jvm",
            version = Version.kotlin
        )

        val kotlinAndroid = Plugin(
            name = "kotlin-android",
            version = Version.kotlin
        )
    }
}
