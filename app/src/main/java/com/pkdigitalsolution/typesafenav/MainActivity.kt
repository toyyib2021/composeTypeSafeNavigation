package com.pkdigitalsolution.typesafenav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.pkdigitalsolution.typesafenav.navigation.NavHost
import com.pkdigitalsolution.typesafenav.ui.theme.TypeSafeNavTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TypeSafeNavTheme {
                val navController = rememberNavController()
                NavHost(navController = navController)

            }
        }
    }
}

