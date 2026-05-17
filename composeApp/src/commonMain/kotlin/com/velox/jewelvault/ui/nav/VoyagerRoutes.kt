package com.velox.jewelvault.ui.nav

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import com.velox.jewelvault.ui.screen.login.LoginScreen
import com.velox.jewelvault.ui.screen.main.MainScreen
import com.velox.jewelvault.ui.screen.splash.SplashScreen
import com.velox.jewelvault.ui.screen.start_loading.StartLoadingScreen
import com.velox.jewelvault.ui.screen.sub.SubScreenPlaceholder
import com.velox.jewelvault.ui.screen.login.LoginScreenModel
import com.velox.jewelvault.ui.screen.main.MainScreenModel
import com.velox.jewelvault.ui.screen.splash.SplashScreenModel
import com.velox.jewelvault.ui.screen.start_loading.StartLoadingScreenModel

object SplashRoute : Screen {
    override val key: String = Screens.Splash.route
    @Composable
    override fun Content() {
        rememberScreenModel { SplashScreenModel() }
        SplashScreen()
    }
}

object LoginRoute : Screen {
    override val key: String = Screens.Login.route
    @Composable
    override fun Content() {
        rememberScreenModel { LoginScreenModel() }
        LoginScreen()
    }
}

object StartLoadingRoute : Screen {
    override val key: String = Screens.StartLoading.route

    @Composable
    override fun Content() {
        rememberScreenModel { StartLoadingScreenModel() }
        StartLoadingScreen()
    }
}

object MainRoute : Screen {
    override val key: String = Screens.Main.route
    @Composable
    override fun Content() {
        rememberScreenModel { MainScreenModel() }
        MainScreen()
    }
}

object SubDashboardRoute : Screen {
    override val key: String = SubScreens.Dashboard.route
    @Composable
    override fun Content() {
        SubScreenPlaceholder(title = "Dashboard")
    }
}

object SubInventoryRoute : Screen {
    override val key: String = SubScreens.Inventory.route
    @Composable
    override fun Content() {
        SubScreenPlaceholder(title = "Inventory")
    }
}

object SubCustomersRoute : Screen {
    override val key: String = SubScreens.Customers.route
    @Composable
    override fun Content() {
        SubScreenPlaceholder(title = "Customers")
    }
}

object SubProfileRoute : Screen {
    override val key: String = SubScreens.Profile.route
    @Composable
    override fun Content() {
        SubScreenPlaceholder(title = "Profile")
    }
}

object SubSettingsRoute : Screen {
    override val key: String = SubScreens.Setting.route
    @Composable
    override fun Content() {
        SubScreenPlaceholder(title = "Settings")
    }
}
