package com.joel.imax.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.joel.imax.model.Movie
import com.joel.imax.view.destinations.DetailsDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(
    movie: Movie,
    navigator: DestinationsNavigator
){
    Card(
        modifier = Modifier
            .padding(10.dp)
            .focusable(),
        shape = RoundedCornerShape(20.dp),
        elevation = 5.dp,
        onClick = {
           navigator.navigate(DetailsDestination(movie))
        }
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = movie.name,
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.weight(2f)
                )
                FavouriteButton()
            }

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                val image = painterResource(movie.imageUrl)
                Image(
                    painter = image,
                    contentDescription = "movie name",
                    modifier = Modifier
                        .width(500.dp)
                        .height(300.dp)
                )
            }
            
            Rating()
            Text(text = movie.rating)
           
            Text(
                text = movie.genre,
                style = MaterialTheme.typography.caption
            )
        }
    }

}