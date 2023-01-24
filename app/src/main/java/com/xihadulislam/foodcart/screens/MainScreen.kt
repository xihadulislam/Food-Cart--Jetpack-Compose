package com.xihadulislam.foodcart.screens

import android.util.Log
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xihadulislam.foodcart.ui.theme.Yellow500


object BottomDestinations {
    const val Home = "Home"
    const val Explorer = "Explorer"
    const val Profile = "Profile"
    const val PrevOrders = "PrevOrders"

}


@Composable
fun MainScreen(navController: NavHostController) {
    var bottomState by remember { mutableStateOf(BottomDestinations.Home) }
    val bottomNavController = rememberNavController()

    Scaffold(
        content = {
            NavHost(
                navController = bottomNavController,
                startDestination = BottomDestinations.Home,
                builder = {

                    composable(BottomDestinations.Home) {
                        HomeScreen(navController = navController)
                    }

                    composable(BottomDestinations.Explorer)
                    {
                        ExploreScreen(navController = navController)
                    }

                    composable(BottomDestinations.PrevOrders)
                    {
                        PevOrderScreen(navController = navController)
                    }

                    composable(BottomDestinations.Profile)
                    {
                        ProfileScreen(navController = navController)
                    }

                })

        },
        bottomBar = {
            BottomNavigation(
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)),
                //  backgroundColor = Color(0xFFFEDBD0),
                backgroundColor = Yellow500,
                contentColor = Color(0xFF442c2E)
            ) {
                BottomNavigationItem(
                    selected = bottomState == BottomDestinations.Home,
                    onClick = {
                        bottomState = BottomDestinations.Home
                        bottomNavController.navigate(BottomDestinations.Home)
                    },
                    label = { Text(text = BottomDestinations.Home) },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) }
                )

                BottomNavigationItem(
                    selected = bottomState == BottomDestinations.Explorer,
                    onClick = {
                        bottomState = BottomDestinations.Explorer
                        bottomNavController.navigate(BottomDestinations.Explorer)
                    },
                    label = { Text(text = BottomDestinations.Explorer) },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Place,
                            contentDescription = null
                        )
                    }
                )
                BottomNavigationItem(
                    selected = bottomState == BottomDestinations.PrevOrders,
                    onClick = {
                        bottomState = BottomDestinations.PrevOrders
                        bottomNavController.navigate(BottomDestinations.PrevOrders)
                    },
                    label = { Text(text = BottomDestinations.PrevOrders) },
                    icon = { Icon(imageVector = Icons.Default.Refresh, contentDescription = null) }
                )
                BottomNavigationItem(
                    selected = bottomState == BottomDestinations.Profile,
                    onClick = {
                        bottomState = BottomDestinations.Profile
                        bottomNavController.navigate(BottomDestinations.Profile)
                    },
                    label = { Text(text = BottomDestinations.Profile) },
                    icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) }
                )

            }
        }
    )
}