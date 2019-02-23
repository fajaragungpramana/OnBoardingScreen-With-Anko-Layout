package com.mengsoftstudio.tutorial.views.activity.ui

import android.support.v4.content.res.ResourcesCompat
import android.view.View
import com.mengsoftstudio.tutorial.R
import com.mengsoftstudio.tutorial.views.activity.LoadingActivity
import org.jetbrains.anko.*

class LoadingActivityUI : AnkoComponent<LoadingActivity> {

    override fun createView(ui: AnkoContext<LoadingActivity>): View = with(ui) {

        relativeLayout {

            textView {

                text = context.getString(R.string.hello_activity_loading)
                textSize = 20f
                textColor = resources.getColor(R.color.colorBlack)
                typeface = ResourcesCompat.getFont(context, R.font.montserrat_regular)

            }.lparams { centerInParent() }

        }

    }

}