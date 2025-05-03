package etf.ri.rma.newsfeedapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.staticCompositionLocalOf
import etf.ri.rma.newsfeedapp.screen.NewsFeedScreen
import etf.ri.rma.newsfeedapp.screen.FilterScreen
import etf.ri.rma.newsfeedapp.screen.NewsDetailsScreen

@Composable
fun NewsNavHost(navController: NavHostController) {
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                NewsFeedScreen()
            }
            composable("filters") { backStackEntry ->
                val initialCategory = backStackEntry.savedStateHandle.get<String>("selected_category") ?: "All"
                FilterScreen(initialCategory = initialCategory)
            }
            composable("details/{id}") { backStackEntry ->
                val newsId = backStackEntry.arguments?.getString("id")
                NewsDetailsScreen(newsId = newsId ?: "", navController = navController)
            }
        }
    }
}

val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("NavController not provided")
}