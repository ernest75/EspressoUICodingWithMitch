package com.example.espressouicodingwithmitch.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.example.espressouicodingwithmitch.R
import com.example.espressouicodingwithmitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private val TAG: String = "AppDebug"

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLaunchDialog.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        MaterialDialog(this)
            .show {
                input(
                    waitForPositiveButton = true,
                    allowEmpty = false
                ) { dialog, name ->
                    setNameToTextView(name.toString())
                }
                title(R.string.text_enter_name)
                positiveButton(R.string.text_ok)
            }
    }

    private fun setNameToTextView(name: String) {
        binding.textName.text = name
    }


}







