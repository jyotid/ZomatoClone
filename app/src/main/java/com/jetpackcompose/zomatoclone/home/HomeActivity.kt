package com.jetpackcompose.zomatoclone.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.goout.GoOutScreen
import com.jetpackcompose.zomatoclone.home.Route.*
import com.jetpackcompose.zomatoclone.order.OrderScreen
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}

@Composable
fun HomeScreen(){
    val navController = rememberNavController()
    val items = listOf(
        Order(ORDER_SCREEN,"Order", R.drawable.ic_order),
        GoOut(GOOUT_SCREEN,"Go Out", R.drawable.ic_go_out),
        Pro(PRO_SCREEN, "Pro", R.drawable.ic_premium),
        Profile(PROFILE_SCREEN,"Profile", R.drawable.ic_profile)
    )
    Scaffold(
        bottomBar = { BottomNavigator(items, navController) }
    ) {
        HomeScreenNavigationConfig(navController)
    }
}

@Composable
fun HomeScreenNavigationConfig(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ORDER_SCREEN.name,
        builder = {
            composable(ORDER_SCREEN.name) {
                OrderScreen()
            }
            composable(GOOUT_SCREEN.name) {
                GoOutScreen()
            }
            composable(PRO_SCREEN.name) {
                OrderScreen()
            }
            composable(PROFILE_SCREEN.name) {
                GoOutScreen()
            }
        })
}
