package com.ortiz.touchdemo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.touch.R
import com.ortiz.touchview.TouchImageView
import kotlinx.android.synthetic.main.activity_viewpager_example.*

class ViewPagerExampleActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewpager_example)
        view_pager.adapter = TouchImageAdapter()
    }

    internal class TouchImageAdapter : PagerAdapter() {

        override fun getCount(): Int {
            return images.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): View {
            val img = TouchImageView(container.context)
            img.setImageResource(images[position])
            container.addView(img, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT)
            return img
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        companion object {

            private val images = intArrayOf(R.drawable.nature_1, R.drawable.nature_2, R.drawable.nature_3, R.drawable.nature_4, R.drawable.nature_5)
        }

    }
}