package com.mengsoftstudio.tutorial.views.activity.ui

import android.support.v4.content.res.ResourcesCompat
import android.view.View
import com.mengsoftstudio.tutorial.R
import com.mengsoftstudio.tutorial.views.activity.OnBoardingActivity
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.viewPager

class OnBoardingActivityUI : AnkoComponent<OnBoardingActivity> {

    override fun createView(ui: AnkoContext<OnBoardingActivity>): View = with(ui) {

        relativeLayout {

            viewPager{ id = R.id.vp_page }.lparams(matchParent, matchParent)

            relativeLayout {

                textView {

                    id = R.id.tv_skip

                    text = context.getString(R.string.lewati)
                    textSize = 15f
                    textColor = resources.getColor(R.color.colorBlack)
                    typeface = ResourcesCompat.getFont(context, R.font.raleway_regular)
                    allCaps = true

                }.lparams { alignParentStart() }

                include<DotsIndicator>(R.layout.support_indicator_dots).lparams { alignParentEnd() }

            }.lparams(matchParent) {

                topMargin = dip(15)

                marginStart = dip(15)
                marginEnd = dip(15)

            }

            button {

                id = R.id.btn_continue

                padding = dip(10)

                background = resources.getDrawable(R.drawable.button_background)

                text = context.getString(R.string.lanjutkan)
                textSize = 18f
                textColor = resources.getColor(R.color.colorWhite)
                typeface = ResourcesCompat.getFont(context, R.font.raleway_regular)
                allCaps = false

            }.lparams {

                bottomMargin = dip(100)

                centerHorizontally()
                alignParentBottom()

            }

            button {

                id = R.id.btn_get_started

                padding = dip(10)

                background = resources.getDrawable(R.drawable.button_background)

                text = context.getString(R.string.memulai)
                textSize = 18f
                textColor = resources.getColor(R.color.colorWhite)
                typeface = ResourcesCompat.getFont(context, R.font.raleway_regular)
                allCaps = false

            }.lparams {

                bottomMargin = dip(100)

                centerHorizontally()
                alignParentBottom()

            }


        }

    }

}