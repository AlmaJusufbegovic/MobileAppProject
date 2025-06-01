package etf.ri.rma.newsfeedapp.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.viewmodel.compose.viewModel
import etf.ri.rma.newsfeedapp.data.network.ImagaDAO
import etf.ri.rma.newsfeedapp.screen.NewsFeedScreen
import etf.ri.rma.newsfeedapp.screen.FilterScreen
import etf.ri.rma.newsfeedapp.screen.NewsDetailsScreen
import etf.ri.rma.newsfeedapp.viewmodel.NewsFeedViewModel

@Composable
fun NewsNavHost(
    navController: NavHostController,
    imagaDAO: ImagaDAO
) {
    CompositionLocalProvider(LocalNavController provides navController) {
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                NewsFeedScreen()
            }
            composable("filters") { backStackEntry ->
                val initialCategory = backStackEntry.savedStateHandle.get<String>("selected_category") ?: "All"
                FilterScreen(initialCategory = initialCategory)
            }
            composable("details/{newsId}") { backStackEntry ->
                val newsId = backStackEntry.arguments?.getString("newsId") ?: ""
                val viewModel: NewsFeedViewModel = viewModel()
                NewsDetailsScreen(
                    newsId = newsId,
                    navController = navController,
                    viewModel = viewModel,
                    imagaDAO = imagaDAO
                )
            }
        }
    }
}


val LocalNavController = staticCompositionLocalOf<NavHostController> {
    error("NavController not provided")
}