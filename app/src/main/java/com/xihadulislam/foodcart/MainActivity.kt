package com.xihadulislam.foodcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xihadulislam.foodcart.screens.DetailScreen
import com.xihadulislam.foodcart.screens.MainScreen
import com.xihadulislam.foodcart.ui.theme.FoodCartTheme


object Destinations {
    const val Main = "Main"
    const val Detail = "Detail"

    object DetailArgs {
        const val foodData = "foodData"
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodCartTheme {
                val navController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = Destinations.Main,
                    builder = {

                        composable(Destinations.Main) {
                            MainScreen(navController = navController)
                        }

                        composable(Destinations.Detail)
                        {
                            DetailScreen(navController = navController)
                        }

                    })
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodCartTheme {

    }
}