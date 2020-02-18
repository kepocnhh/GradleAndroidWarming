package gradle.android.warming

import androidx.multidex.MultiDexApplication
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

class App: MultiDexApplication() {

    private val defaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()

    override fun onCreate() {
        super.onCreate()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            //todo
            defaultExceptionHandler.uncaughtException(thread, throwable)
        }
        Fabric.with(this, Crashlytics())
    }
}
