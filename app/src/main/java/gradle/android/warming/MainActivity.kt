package gradle.android.warming

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.google.android.gms.tasks.Tasks
import com.google.android.material.button.MaterialButton
import com.google.firebase.iid.FirebaseInstanceId
import com.yandex.mapkit.mapview.MapView
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.concurrent.thread

class MainActivity: AppCompatActivity() {

    private fun getToken(
        timeoutMilliseconds: Long
    ): String {
        return Tasks.await(
            FirebaseInstanceId.getInstance().instanceId,
            timeoutMilliseconds,
            TimeUnit.MILLISECONDS
        ).token
    }

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        val rootView: View = FrameLayout(this).apply {
            addView(TextView(context).apply { text = "gradle.android.warming" })
            addView(MaterialButton(context).apply { text = "MaterialButton" })
            addView(MapView(context))
        }
        setContentView(rootView)
        var result: String? = null
        val isFinish = AtomicBoolean(false)
        thread {
            result = try {
                getToken(250)
            } catch (e: Throwable) {
                null
            }
            isFinish.set(true)
        }
        while(!isFinish.get());
        result?.also { token ->
            Log.i(this::class.java.name, "token: $token")
        }
    }
}
