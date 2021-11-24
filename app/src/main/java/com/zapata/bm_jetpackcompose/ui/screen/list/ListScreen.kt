package com.zapata.bm_jetpackcompose.ui.screen.list

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.zapata.bm_jetpackcompose.R
import com.zapata.bm_jetpackcompose.ui.theme.fabBackgroundColor
import com.zapata.bm_jetpackcompose.ui.viewmodel.SharedViewModel
import com.zapata.bm_jetpackcompose.utils.SearchAppBarState

/* 
 * @author Alberto Zapata
 *  nov 2021
 */
@ExperimentalMaterialApi
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {

    LaunchedEffect(key1 = true){
        sharedViewModel.getAllTask()
    }
    val allTasks by sharedViewModel.allTask.collectAsState()




    val searchAppBarState: SearchAppBarState by sharedViewModel.searchAppBarState
    val searchTextState: String by sharedViewModel.searchTextState
    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            ListContent(
                tasks = allTasks,
                navigationToTaskScree = navigateToTaskScreen
            )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)

        }
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        },
        backgroundColor = MaterialTheme.colors.fabBackgroundColor
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(
                id = R.string.add_button
            ),
            tint = Color.White
        )
    }
}
//
//@Composable
//@Preview
//private fun ListScreenPreview() {
//    ListScreen(navigateToTaskScreen = {})
//}