package com.zapata.bm_jetpackcompose.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.Coil
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.zapata.bm_jetpackcompose.navigation.SetupNavigation
import com.zapata.bm_jetpackcompose.ui.theme.BMJetpackComposeTheme
import com.zapata.bm_jetpackcompose.ui.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import android.net.wifi.WifiInfo

import android.net.wifi.WifiManager





@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    
    private lateinit var navController: NavHostController

    private val sharedViewModel: SharedViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMJetpackComposeTheme{
                
                navController = rememberNavController()
                SetupNavigation(
                    navController = navController,
                    sharedViewModel = sharedViewModel
                )

            }
        }
    }
}
