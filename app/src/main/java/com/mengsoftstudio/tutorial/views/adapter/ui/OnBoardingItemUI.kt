package com.mengsoftstudio.tutorial.views.adapter.ui

import android.support.v4.content.res.ResourcesCompat
import android.view.Gravity
import android.view.View
import com.mengsoftstudio.tutorial.R
import com.mengsoftstudio.tutorial.views.adapter.OnBoardingItem
import org.jetbrains.anko.*

class OnBoardingItemUI : AnkoComponent<OnBoardingItem> {

    override fun createView(ui: AnkoContext<OnBoardingItem>): View = with(ui) {

        relativeLayout {

            textView {

                id = R.id.tv_title

                textSize = 20f
                textColor = resources.getColor(R.color.colorBlack)
                typeface = ResourcesCompat.getFont(context, R.font.montserrat_regular)

            }.lparams { centerInParent() }

            textView {

                id = R.id.tv_subtitle

                gravity = Gravity.CENTER

                textSize = 15f
                textColor = resources.getColor(R.color.colorBlack)
                typeface = ResourcesCompat.getFont(context, R.font.raleway_regular)

            }.lparams {

                topMargin = dip(30)

                below(R.id.tv_title)
                centerHorizontally()

                marginStart = dip(50)
                marginEnd = dip(50)

            }

            imageView {

                id = R.id.iv_content_image

            }.lparams {

                bottomMargin = dip(50)

                above(R.id.tv_title)
                centerHorizontally()

            }

        }

    }

}