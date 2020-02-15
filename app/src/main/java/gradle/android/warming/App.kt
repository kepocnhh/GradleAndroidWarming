package gradle.android.warming

import androidx.multidex.MultiDexApplication

class App: MultiDexApplication() {

    private val defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()

    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            //todo
            defaultExceptionHandler.uncaughtException(thread, throwable)
        }
    }
}
