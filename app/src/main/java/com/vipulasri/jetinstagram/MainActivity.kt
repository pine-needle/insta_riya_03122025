package com.vipulasri.jetinstagram

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.google.firebase.messaging.FirebaseMessaging
import com.vipulasri.jetinstagram.ui.MainScreen
import com.vipulasri.jetinstagram.ui.theme.JetInstagramTheme

class MainActivity : AppCompatActivity() {
  private val TAG: String = "MainActivityLogs"

  @ExperimentalFoundationApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    this.setContent {
      JetInstagramTheme {
        Surface(color = MaterialTheme.colors.background) {
          MainScreen()
        }

      }
    }
    //get registration token
    FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
      if (!task.isSuccessful) {
        Log.w(TAG, "Fetching FCM registration token failed", task.exception)
      }else {

        // Get new FCM registration token
        val token = task.result

        // Log and toast
//        val msg = getString(R.string.msg_token_fmt, token)
        Log.d(TAG, "Token Received = $token")
        Toast.makeText(baseContext, "Got the token!", Toast.LENGTH_SHORT).show()
      }

    }


  }

}