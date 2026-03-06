package com.example.helpai

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.helpai.presentation.ScreenHomeAI.ChatUi

object appRouts {
    const val ScreenHOME = "screenhome"

}
@Composable
fun AppNavigation() {

    var navcantroller = rememberNavController()

    val startDestination = appRouts.ScreenHOME

    NavHost(
        navController = navcantroller,
        startDestination = startDestination
    ) {

        composable (appRouts.ScreenHOME){
            ChatUi(
                navController = navcantroller,
                Back = {
                    navcantroller.popBackStack()
                }
            )

        }

    }

}