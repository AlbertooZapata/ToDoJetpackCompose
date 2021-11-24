package com.zapata.bm_jetpackcompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.zapata.bm_jetpackcompose.utils.Action
import com.zapata.bm_jetpackcompose.utils.Constants
import com.zapata.bm_jetpackcompose.utils.Constants.TASK_ARGUMENT_KEY
import com.zapata.bm_jetpackcompose.utils.Constants.TASK_SCREEN

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ){

    }
}