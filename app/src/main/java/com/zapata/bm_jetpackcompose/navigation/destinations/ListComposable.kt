package com.zapata.bm_jetpackcompose.navigation.destinations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zapata.bm_jetpackcompose.ui.screen.list.ListScreen
import com.zapata.bm_jetpackcompose.ui.viewmodel.SharedViewModel
import com.zapata.bm_jetpackcompose.utils.Constants
import com.zapata.bm_jetpackcompose.utils.Constants.LIST_ARGUMENT_KEY
import com.zapata.bm_jetpackcompose.utils.Constants.LIST_SCREEN

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
        navigateToTaskScreen: (taskId: Int) -> Unit,
        sharedViewModel: SharedViewModel
 ){
     composable(
         route = LIST_SCREEN,
         arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
             type = NavType.StringType
         })
     ){

         ListScreen(
             navigateToTaskScreen = navigateToTaskScreen,
             sharedViewModel = sharedViewModel
         )

     }
 }