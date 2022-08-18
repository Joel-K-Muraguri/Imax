package com.joel.imax.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joel.imax.components.ItemCard
import com.joel.imax.model.DataStore
import com.joel.imax.model.Movie
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination(start = true)
@Composable
fun Home(
    navigator: DestinationsNavigator,
){
    val movies = remember {
        DataStore.movieList
    }
    LazyColumn(modifier = Modifier
        .padding(20.dp)
    ){
        item { 
           Column(modifier = Modifier.padding(8.dp)) {
               Text(
                   text = "Hey Joel",
                   style = MaterialTheme.typography.h5
               )

               Text(
                   text = "Welcome to my Movie App",
                   style = MaterialTheme.typography.h6
               )
           }
        }
        items(
            items = movies,
            itemContent = {
                ItemCard(
                    movie = it,
                    navigator = navigator
                )
            }
        )
    }
}


