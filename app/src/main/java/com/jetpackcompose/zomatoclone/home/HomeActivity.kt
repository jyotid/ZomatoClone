package com.jetpackcompose.zomatoclone.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.setContent

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                    bottomBar = {
                        BottomNavigator()
                    }
            ) {

            }
        }

    }
}
