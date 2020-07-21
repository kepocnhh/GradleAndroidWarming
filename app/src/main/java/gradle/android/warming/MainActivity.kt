package gradle.android.warming

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.app.Activity
import android.widget.TextView
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

class MainActivity : Activity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        val rootView: View = FrameLayout(this).apply {
            addView(TextView(context).apply { text = "gradle.android.warming" })
        }
        setContentView(rootView)
    }
}
