package com.project01.siakad1.chat

import android.content.Context
import androidx.annotation.Nullable
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.project01.siakad1.R

class AdapterViewPager (private val mContext: Context, mfragmentManager: FragmentManager)
    : FragmentPagerAdapter(mfragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val Tab = intArrayOf(
            R.string.siswa,
            R.string.guru
        )
    }
    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        /*when (position) {
            0 -> fragment = SiswaFragment()
            1 -> fragment = GuruFragment()
        }*/
        return fragment as Fragment
    }
    @Nullable
    override fun getPageTitle(position: Int): CharSequence? {
        return mContext.resources.getString(Tab[position])
    }
    override fun getCount(): Int {
        return 2
    }
}