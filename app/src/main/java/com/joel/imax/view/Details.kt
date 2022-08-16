package com.joel.imax.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.joel.imax.view.destinations.HomeDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun Details(
    navigator: DestinationsNavigator,
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navigator.navigate(HomeDestination)
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Details",
            textAlign = TextAlign.Center,
            fontSize = 40.sp

        )
    }
}