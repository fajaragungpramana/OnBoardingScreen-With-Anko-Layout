package com.mengsoftstudio.tutorial.views.adapter

import android.content.Context
import android.content.res.TypedArray
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.mengsoftstudio.tutorial.R
import com.mengsoftstudio.tutorial.views.adapter.ui.OnBoardingItemUI
import com.squareup.picasso.Picasso
import org.jetbrains.anko.AnkoContext

class OnBoardingItem(private val context: Context) : PagerAdapter() {

    private fun getImages(): TypedArray = context.resources.obtainTypedArray(R.array.on_boarding_images)
    private fun getTitles(): Array<String> = context.resources.getStringArray(R.array.on_boarding_titles)
    private fun getSubtitles(): Array<String> = context.resources.getStringArray(R.array.on_boarding_subtitles)

    override fun isViewFromObject(p0: View, p1: Any): Boolean = p0 == p1 as RelativeLayout

    override fun getCount(): Int = getTitles().size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = OnBoardingItemUI().createView(AnkoContext.create(context, this))
        container.addView(view)

        updateUI(view, position)

        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) { container.removeView(`object` as RelativeLayout) }

    private fun updateUI(view: View, i: Int) {

        val image = view.findViewById<ImageView>(R.id.iv_content_image)
        val title = view.findViewById<TextView>(R.id.tv_title)
        val subtitle = view.findViewById<TextView>(R.id.tv_subtitle)

        getImages().recycle()

        Picasso.get().load(getImages().getResourceId(i, 0)).into(image)
        title.text = getTitles()[i]
        subtitle.text = getSubtitles()[i]

        image.scaleY = 0f
        image.scaleX = 0f
        image.animate().scaleY(1f).scaleX(1f).setDuration(800).start()

        title.alpha = 0f
        title.translationY = 500f
        title.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(300).start()

        subtitle.alpha = 0f
        subtitle.translationY = 500f
        subtitle.animate().alpha(1f).translationY(0f).setDuration(800).setStartDelay(600).start()

    }

}