package woowacourse.movie.ui.storage

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

object SettingsStorage {
    private var sharedPref: SharedPreferences? = null
    private const val KEY_PUSH_NOTIFICATION = "push_notification"

    fun init(context: Context) {
        sharedPref = context.getSharedPreferences("settings", MODE_PRIVATE)
    }

    fun getPushNotification(): Boolean =
        sharedPref?.getBoolean(KEY_PUSH_NOTIFICATION, false) ?: false

    fun editPushNotification(activate: Boolean) {
        sharedPref?.edit()?.putBoolean(KEY_PUSH_NOTIFICATION, activate)?.apply()
    }
}
