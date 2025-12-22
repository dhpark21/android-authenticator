package proton.android.authenticator.navigation.domain.navigators

import androidx.compose.material.navigation.BottomSheetNavigator
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import proton.android.authenticator.navigation.domain.flows.NavigationFlow

interface NavigationNavigator {

    @Composable
    fun NavGraphs(
        isDarkTheme: Boolean,
        bottomSheetNavigator: BottomSheetNavigator,
        navController: NavHostController,
        onFinishLaunching: () -> Unit,
        onLaunchNavigationFlow: (NavigationFlow) -> Unit,
        onAskForReview: () -> Unit
    )

}
