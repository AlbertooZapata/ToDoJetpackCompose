package com.zapata.bm_jetpackcompose.navigation

import androidx.navigation.NavHostController
import com.zapata.bm_jetpackcompose.utils.Action
import com.zapata.bm_jetpackcompose.utils.Constants
import com.zapata.bm_jetpackcompose.utils.Constants.LIST_SCREEN

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}"){
            popUpTo(LIST_SCREEN) {inclusive = true }
        }
    }
    val task: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}