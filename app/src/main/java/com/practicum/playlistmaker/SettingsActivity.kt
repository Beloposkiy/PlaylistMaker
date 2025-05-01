package com.practicum.playlistmaker

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val shareTextView = findViewById<MaterialTextView>(R.id.share_textView)
        val supportTextView = findViewById<MaterialTextView>(R.id.support_textView)
        val agreementTextView = findViewById<MaterialTextView>(R.id.agreement_textView)

        val supportEmail = getString(R.string.email)
        val supportEmailSubject = Uri.encode(getString(R.string.support_subject))
        val supportEmailText = Uri.encode(getString(R.string.support_text))


        shareTextView.setOnClickListener {
            val shareText = getString(R.string.share_text)

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, shareText)
            }

            startActivity(Intent.createChooser(shareIntent, "Поделиться приложением через"))
        }

        supportTextView.setOnClickListener{
            val uri = Uri.parse("mailto:$supportEmail?subject=$supportEmailSubject&body=$supportEmailText")

            val supportIntent = Intent(Intent.ACTION_SENDTO, uri)

            try {
                startActivity(Intent.createChooser(supportIntent, "Выберете почтовое прилолжение"))
            } catch(e: ActivityNotFoundException){
                Toast.makeText(this, "Нет устоновленного почтового клиента", Toast.LENGTH_LONG).show()
            }
        }

        agreementTextView.setOnClickListener {
            val url = getString(R.string.agreement_link)

            val agreementIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            startActivity(agreementIntent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_settings)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.settings_toolbar_button)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }
}
