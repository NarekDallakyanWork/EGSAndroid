package egs.android.ui.main

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import egs.android.R
import egs.android.base.activity.BaseActivity
import egs.android.base.navigator.screens.Screens

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Setting container id to Navigator
        navigator.setContainer(R.id.main_fragments_container)
        if (savedInstanceState == null) {
            // Opening Movies List fragment
            openFragment(Screens.MOVIES_LIST)
        }
    }
}