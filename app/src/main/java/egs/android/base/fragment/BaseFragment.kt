package egs.android.base.fragment

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import egs.android.base.activity.BaseActivity
import egs.android.base.navigator.screens.Screens

@AndroidEntryPoint
abstract class BaseFragment(@LayoutRes layout: Int) : Fragment(layout) {

    fun openFragment(
        screen: Screens,
        bundle: Bundle? = null,
        recreate: Boolean = false,
        removeCurrentScreen: Boolean = false
    ) {
        if (activity == null) return

        (activity as BaseActivity).openFragment(screen, bundle, recreate, removeCurrentScreen)
    }

    fun goToBack(
        recreate: Boolean = false, bundle: Bundle? = null
    ) {
        if (activity == null) return
        (activity as BaseActivity).navigator.goBack(recreate, bundle)
    }
}