package com.jetpackcompose.zomatoclone.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpackcompose.zomatoclone.R
import com.jetpackcompose.zomatoclone.components.BottomNavigatorComponent
import com.jetpackcompose.zomatoclone.goout.GoOutScreen
import com.jetpackcompose.zomatoclone.home.Route.*
import com.jetpackcompose.zomatoclone.order.OrderScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity(homePresenter: HomePresenter = HomePresenter()) : AppCompatActivity() {

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen(homePresenter)
        }
    }
}

@Composable
fun HomeScreen(homePresenter: HomePresenter) {
    val navController = rememberNavController()
    val items = listOf(
            Order(ORDER_SCREEN, "Order", R.drawable.ic_order),
            GoOut(GOOUT_SCREEN, "Go Out", R.drawable.ic_go_out),
            Pro(PRO_SCREEN, "Pro", R.drawable.ic_premium),
            Profile(PROFILE_SCREEN, "Profile", R.drawable.ic_profile)
    )
    Scaffold(
            bottomBar = { BottomNavigatorComponent(items, navController) }
    ) {
        HomeScreenNavigationConfig(navController, homePresenter = homePresenter)
    }
}

@Composable
fun HomeScreenNavigationConfig(navController: NavHostController, homePresenter: HomePresenter) {
    NavHost(
            navController = navController,
            startDestination = ORDER_SCREEN.name,
            builder = {
                composable(ORDER_SCREEN.name) {
                    OrderScreen(homePresenter.uiState.observeAsState().value!!, homePresenter::onFilterItemClicked)
                }
                composable(GOOUT_SCREEN.name) {
                    GoOutScreen()
                }
                composable(PRO_SCREEN.name) {
                    OrderScreen(homePresenter.uiState.observeAsState().value!!, homePresenter::onFilterItemClicked)
                }
                composable(PROFILE_SCREEN.name) {
                    GoOutScreen()
                }
            })
}
