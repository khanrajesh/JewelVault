package com.velox.jewelvault.ui.screen.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.velox.jewelvault.ui.nav.LocalSubNavigator
import com.velox.jewelvault.ui.nav.SubCustomersRoute
import com.velox.jewelvault.ui.nav.SubDashboardRoute
import com.velox.jewelvault.ui.nav.SubInventoryRoute
import com.velox.jewelvault.ui.nav.SubProfileRoute
import com.velox.jewelvault.ui.nav.SubSettingsRoute

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Text(text = "JewelVault", style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "Main navigation (nested SubScreens)",
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Navigator(SubDashboardRoute) { subNavigator ->
            CompositionLocalProvider(LocalSubNavigator provides subNavigator) {
                SubNavigationRow(subNavigator)
                Spacer(modifier = Modifier.height(16.dp))
                CurrentScreen()
            }
        }
    }
}

@Composable
private fun SubNavigationRow(subNavigator: Navigator) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Button(onClick = { subNavigator.replace(SubDashboardRoute) }) {
            Text("Dashboard")
        }
        Button(onClick = { subNavigator.replace(SubInventoryRoute) }) {
            Text("Inventory")
        }
        Button(onClick = { subNavigator.replace(SubCustomersRoute) }) {
            Text("Customers")
        }
        Button(onClick = { subNavigator.replace(SubProfileRoute) }) {
            Text("Profile")
        }
        Button(onClick = { subNavigator.replace(SubSettingsRoute) }) {
            Text("Settings")
        }
    }
}
