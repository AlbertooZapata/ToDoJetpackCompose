package com.zapata.bm_jetpackcompose.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.zapata.bm_jetpackcompose.navigation.destinations.listComposable
import com.zapata.bm_jetpackcompose.navigation.destinations.taskComposable
import com.zapata.bm_jetpackcompose.ui.viewmodel.SharedViewModel
import com.zapata.bm_jetpackcompose.utils.Constants
import com.zapata.bm_jetpackcompose.utils.Constants.LIST_SCREEN

/* 
 * @author Alberto Zapata
 *  nov 2021
 */

@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val screen = remember(navController){
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ){
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            navigateToListScreen = screen.list
        )
    }
}
