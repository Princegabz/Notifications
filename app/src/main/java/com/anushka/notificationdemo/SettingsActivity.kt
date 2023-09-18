package com.anushka.notificationdemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    companion object {
        const val PREFS_NAME = "NotificationPrefs"
        const val PREF_KEY_NOTIFICATIONS_ENABLED = "notifications_enabled"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        val notificationsEnabledCheckbox = findViewById<CheckBox>(R.id.notificationsEnabledCheckbox)

        // Load the current notification setting
        val notificationsEnabled = sharedPreferences.getBoolean(PREF_KEY_NOTIFICATIONS_ENABLED, true)
        notificationsEnabledCheckbox.isChecked = notificationsEnabled

        notificationsEnabledCheckbox.setOnCheckedChangeListener { _, isChecked ->
            // Save the user's preference for notifications
            sharedPreferences.edit().putBoolean(PREF_KEY_NOTIFICATIONS_ENABLED, isChecked).apply()
        }
    }
}
