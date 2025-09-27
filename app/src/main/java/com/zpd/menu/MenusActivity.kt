package com.zpd.menu

import android.os.Bundle
import androidx.core.view.WindowInsetsCompat
import com.zpd.menu.ui.BaseActivity
import com.zpd.menu.ui.MenusFragment

class MenusActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus)

        hideSystembar()

        var beginTransaction =supportFragmentManager.beginTransaction()
        var mMenusFragment = MenusFragment.newInstance()
        beginTransaction.add(R.id.main,mMenusFragment,"MenusFragment").commit()

    }

    fun hideSystembar(){
        var windowInsetsController = window.decorView.windowInsetsController
        windowInsetsController?.hide(WindowInsetsCompat.Type.systemBars())
    }
}