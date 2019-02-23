package com.mengsoftstudio.tutorial.views.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mengsoftstudio.tutorial.views.activity.ui.LoadingActivityUI
import org.jetbrains.anko.setContentView

class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoadingActivityUI().setContentView(this)
    }

}