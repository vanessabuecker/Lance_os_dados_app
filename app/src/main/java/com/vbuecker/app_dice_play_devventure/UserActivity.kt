package com.vbuecker.app_dice_play_devventure

import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.vbuecker.app_lanamento_dados_devventure.R
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        setSupportActionBar(toolbar)

        navController = findNavController(R.id.NavHostFragment)
        appBarConfiguration = AppBarConfiguration((navController.graph))

        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        toolbar.navigationIcon?.apply {
            setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN)
        }

        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}










