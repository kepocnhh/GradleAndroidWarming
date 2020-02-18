package gradle.android.warming

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MessagingService: FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i(this::class.java.name, "token: $token")
    }
}
