package gradle.android.warming

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class MainActivity: AppCompatActivity() {

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(TextView(this).apply { setText("gradle.android.warming") })
    }
}
