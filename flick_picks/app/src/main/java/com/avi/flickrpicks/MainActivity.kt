package com.avi.flickrpicks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.avi.flickrpicks.ui.screens.ImageDetailsPage
import com.avi.flickrpicks.ui.screens.ImagesListPage
import com.avi.flickrpicks.ui.theme.FlickrPicksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FlickrPicksTheme {
                FlickrPicksApp()
            }
        }
    }
}

@Composable
fun FlickrPicksApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "images_list"
    ) {
        composable("images_list") {
            ImagesListPage()
        }

        composable(
            route = "image_details/{imageName}",
            arguments = listOf(
                navArgument("imageName") { type = NavType.StringType }
            )
        ) {
            ImageDetailsPage()
        }
    }
}