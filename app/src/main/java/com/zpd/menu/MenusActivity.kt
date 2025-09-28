package com.zpd.menu

import android.os.Bundle
import android.view.WindowInsetsController
import androidx.core.view.WindowInsetsCompat
import com.zpd.menu.ui.BaseActivity
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
        beginTransaction.add(R.id.main,mMenusFragment,"MenusFragment").commit()

    }

    fun hideSystembar(){
        var windowInsetsController = window.decorView.windowInsetsController
        windowInsetsController?.hide(WindowInsetsCompat.Type.navigationBars())
//        setSystemBarsAppearance(APPEARANCE_LIGHT_STATUS_BARS, APPEARANCE_LIGHT_STATUS_BARS) //状态栏设置为黑色
//        setSystemBarsAppearance(0, APPEARANCE_LIGHT_STATUS_BARS) //状态栏设置成白色
        windowInsetsController?.setSystemBarsAppearance(0,WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS)
    }
}