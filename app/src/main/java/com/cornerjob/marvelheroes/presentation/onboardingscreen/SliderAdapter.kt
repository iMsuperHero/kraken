package com.cornerjob.marvelheroes.presentation.onboardingscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.cornerjob.marvelheroes.R
import com.cornerjob.marvelheroes.domain.model.Slide


class SliderAdapter(context: Context, slideItems: List<Slide>) : PagerAdapter() {

    var mContext = context

    var mSlideItems = slideItems


    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object`
    }

    override fun getCount(): Int {

        return mSlideItems.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
                mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.slide_layout, container, false)
        container.addView(view)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val slideHeading = view.findViewById<TextView>(R.id.tvHeading)
        val slideDescription = view.findViewById<TextView>(R.id.tvSubHeading)

        imageView.setImageResource(mSlideItems[position].image)

        slideHeading.text = mSlideItems[position].heading
        slideDescription.text = mSlideItems[position].subHeading


        return view

    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as ConstraintLayout)
    }

}