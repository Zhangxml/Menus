package com.zpd.menu

import android.os.Bundle
import android.view.WindowInsetsController
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import com.zpd.menu.tool.MLog
import com.zpd.menu.ui.BaseActivity
import com.zpd.menu.ui.EditFragment
import com.zpd.menu.ui.MenusFragment

/*
* 1. git add .
*
* 2. git commit --allow-empty-message
*
* 3. git push origin main
*
* */
class MenusActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus)


        hideSystembar()
        var beginTransaction =supportFragmentManager.beginTransaction()
        var mMenusFragment = MenusFragment.newInstance()
        beginTransaction?.add(R.id.main,mMenusFragment,"MenusFragment")?.commit()

        addOnBackStackChangedListener()
    }


    fun lightSystembar(){
        var windowInsetsController = window.decorView.windowInsetsController
        windowInsetsController?.hide(WindowInsetsCompat.Type.navigationBars())
        windowInsetsController?.setSystemBarsAppearance(0,WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
    }

    fun darkSystembar(){
        var windowInsetsController = window.decorView.windowInsetsController
        windowInsetsController?.hide(WindowInsetsCompat.Type.navigationBars())
        windowInsetsController?.setSystemBarsAppearance(WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
    }

    fun hideSystembar(){
        var windowInsetsController = window.decorView.windowInsetsController
        windowInsetsController?.hide(WindowInsetsCompat.Type.navigationBars())
        windowInsetsController?.setSystemBarsAppearance(0,WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
    }

    fun goEdit(){
        darkSystembar()

        var beginTransaction =supportFragmentManager.beginTransaction()
        var mEditFragment = EditFragment.newInstance()
        beginTransaction?.replace(R.id.main,mEditFragment,"EditFragment")?.addToBackStack("EditFragment")?.commit()
    }

    fun addOnBackStackChangedListener(){
        supportFragmentManager.addOnBackStackChangedListener( {
            var added = supportFragmentManager.findFragmentByTag("MenusFragment")?.isAdded
            if (added!!){
                lightSystembar()
            }
        })
    }
}