package com.practicum.playlistmaker

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText

class SearchActivity : AppCompatActivity() {

    private lateinit var editText: TextInputEditText
    private var searchText: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        editText = findViewById(R.id.search_edit_text)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_search)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val clearIcon = findViewById<ImageView>(R.id.clear_image)

        clearIcon.setOnClickListener {
            editText.setText("")
            val imm =
                (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).also {
                    it.hideSoftInputFromWindow(editText.windowToken, 0)
                }
            editText.clearFocus()
        }



        fun clearIconVisibility(s: CharSequence?): Int {
            return if (s.isNullOrEmpty()) View.GONE else View.VISIBLE
        }

        val toolbarNaviagationButton = findViewById<MaterialToolbar>(R.id.search_toolbar_button)
        toolbarNaviagationButton.setNavigationOnClickListener {
            finish()
        }

        val searchTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                clearIcon.visibility = clearIconVisibility(s)
            }

            override fun afterTextChanged(s: Editable?) {
                searchText = s?.toString() ?: ""
            }
        }

        editText.addTextChangedListener(searchTextWatcher)
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putString("search_text", editText.text?.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val searchText = savedInstanceState.getString("search_text", "")
        editText.setText(searchText)
    }
}