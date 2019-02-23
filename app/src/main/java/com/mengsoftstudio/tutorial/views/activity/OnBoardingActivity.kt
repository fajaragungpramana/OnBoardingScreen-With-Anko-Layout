package com.mengsoftstudio.tutorial.views.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mengsoftstudio.tutorial.R
import com.mengsoftstudio.tutorial.views.activity.ui.OnBoardingActivityUI
import com.mengsoftstudio.tutorial.views.adapter.OnBoardingItem
import kotlinx.android.synthetic.main.support_indicator_dots.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.setContentView

class OnBoardingActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        private const val PREF_BOARDING_TAG = "Pref OnBoardingActivity"
    }

    private lateinit var skipBtn: TextView
    private lateinit var pageContainer: ViewPager
    private lateinit var continueBtn: Button
    private lateinit var startedBtn: Button

    private lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        OnBoardingActivityUI().setContentView(this)

        initView()
        setPageView()
        setAnimate()

        sharedPref = getSharedPreferences(PREF_BOARDING_TAG, Context.MODE_PRIVATE)
        if(!sharedPref.getBoolean(PREF_BOARDING_TAG, true)) {
            destroyActivity()
        }

        skipBtn.setOnClickListener(this@OnBoardingActivity)
        continueBtn.setOnClickListener(this@OnBoardingActivity)
        startedBtn.setOnClickListener(this@OnBoardingActivity)

    }

    private fun initView() {

        skipBtn = findViewById(R.id.tv_skip)
        pageContainer = findViewById(R.id.vp_page)
        continueBtn = findViewById(R.id.btn_continue)
        startedBtn = findViewById(R.id.btn_get_started)

    }

    private fun setAnimate() {

        continueBtn.alpha = 1f
        continueBtn.translationY = 0f

        startedBtn.alpha = 0f
        startedBtn.translationY = 500f

    }

    private fun setPageView() {

        pageContainer.adapter = OnBoardingItem(this@OnBoardingActivity)
        di_page_indicator.setViewPager(pageContainer)

        pageContainer.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(p0: Int) {}

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}

            override fun onPageSelected(p0: Int) {

                when(p0) {

                    3 -> {

                        continueBtn.animate().alpha(0f).translationY(500f).setDuration(800).start()
                        startedBtn.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(300).start()

                    }

                    else -> {

                        startedBtn.animate().alpha(0f).translationY(500f).setDuration(800).start()
                        continueBtn.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(300).start()

                    }

                }

            }

        })

    }

    private fun setPageItemView() {
        pageContainer.currentItem = pageContainer.currentItem + 1
    }

    private fun destroyActivity() {

        startActivity(intentFor<LoadingActivity>()
            .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))

        finish()

    }

    private fun writeSharedPref() {
        sharedPref.edit()
            .putBoolean(PREF_BOARDING_TAG, false)
            .apply()
    }

    override fun onClick(v: View?) {

        when(v?.id) {

            R.id.tv_skip -> {

                writeSharedPref()
                destroyActivity()

            }

            R.id.btn_continue -> setPageItemView()

            R.id.btn_get_started -> {

                writeSharedPref()
                destroyActivity()

            }

        }

    }

}