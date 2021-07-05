package com.example.espressouicodingwithmitch.ui

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.espressouicodingwithmitch.databinding.ActivityMainBinding

const val REQUEST_IMAGE_CAPTURE = 1234
const val KEY_IMAGE_DATA = "data"

class MainActivity : AppCompatActivity(){

    private val TAG: String = "AppDebug"

    private lateinit var binding: ActivityMainBinding

    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            // There are no request codes
            val data: Intent? = result.data
            Log.d(TAG, "RESULT_OK")
            data?.extras.let{ extras ->
                if (extras != null && extras.containsKey(KEY_IMAGE_DATA)) {
                    val imageBitmap = extras[KEY_IMAGE_DATA] as Bitmap?
                    binding.image.setImageBitmap(imageBitmap)
                    Log.d(TAG, "REQUEST_IMAGE_CAPTURE detected.")
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOpenGallery.setOnClickListener {
            dispatchCameraIntent()
        }
    }

    private fun dispatchCameraIntent() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        resultLauncher.launch(intent)
    }

}







