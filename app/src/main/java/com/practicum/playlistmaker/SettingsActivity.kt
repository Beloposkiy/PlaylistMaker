package com.practicum.playlistmaker

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val shareButton = findViewById<View>(R.id.share_button)
        val supportButton = findViewById<View>(R.id.support_button)
        val agreementButton= findViewById<View>(R.id.agreement_button)

        val searchTabBarButton = findViewById<View>(R.id.search_tab_bar_button)
        val mediaLibraryTabBarButton = findViewById<View>(R.id.media_library_tab_bar_button)
        val settingsTabBarButton= findViewById<View>(R.id.settings_tab_bar_button)



        shareButton.findViewById<TextView>(R.id.label).setText(R.string.share)
        shareButton.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_share)

        supportButton.findViewById<TextView>(R.id.label).setText(R.string.support)
        supportButton.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_support)

        agreementButton.findViewById<TextView>(R.id.label).setText(R.string.user_agreement)
        agreementButton.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_arrow_forward)

        searchTabBarButton.findViewById<TextView>(R.id.label).setText(R.string.search)
        searchTabBarButton.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_search)

        mediaLibraryTabBarButton.findViewById<TextView>(R.id.label).setText(R.string.mediaLibrary)
        mediaLibraryTabBarButton.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_media_library)

        settingsTabBarButton.findViewById<TextView>(R.id.label).setText(R.string.settings)
        settingsTabBarButton.findViewById<ImageView>(R.id.icon).setImageResource(R.drawable.ic_settings)




    }
}