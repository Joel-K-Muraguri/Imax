package com.joel.imax.view

import android.widget.Toast
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.joel.imax.R
import com.joel.imax.components.Rating
import com.joel.imax.model.Movie
import com.joel.imax.view.destinations.HomeDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.popUpTo

@Destination
@Composable
fun Details(
    navigator: DestinationsNavigator,
    movie: Movie
) {
    LazyColumn(
        modifier = Modifier
            .padding(12.dp)
    ){
        item {

            ToolsButton(navigator)

            val image = painterResource(id = movie.imageUrl)
            Image(
                painter = image,
                contentDescription = "peaky blinders",
                modifier = Modifier
                    .fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }
        item{


            Text(
                text = movie.name,
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center
            )

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.padding(5.dp),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    val play = painterResource(id = R.drawable.ic_baseline_play_arrow_24)
                    Icon(
                        painter = play,
                        contentDescription = ""
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(text = "Play Trailer")
                }
            }



            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Rating()
                Text(text = movie.rating)
            }


            Text(
                text = movie.description,
                style = MaterialTheme.typography.caption
            )

        }
    }
}

@Composable
fun ToolsButton(
    navigator: DestinationsNavigator
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(contentAlignment = Alignment.TopStart) {
            Button(
                onClick = {
                    navigator.navigate(HomeDestination) {
                        popUpTo(HomeDestination)
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.LightGray,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(20.dp),

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                    contentDescription = "arrow_back_icon",
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
        Spacer(modifier = Modifier.width(200.dp))
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .background(
                    color = Color.LightGray,
                    shape = RoundedCornerShape(20.dp)
                ),
        ) {
            val isClicked = remember {
                mutableStateOf(false)
            }
            val context = LocalContext.current

            IconToggleButton(

                checked = isClicked.value,
                onCheckedChange =
                {
                    isClicked.value =! isClicked.value
                },
                modifier = Modifier
                    .clickable {
                        if (isClicked.value != isClicked.value)
                            Toast
                                .makeText(context, " Added to Favourite", Toast.LENGTH_LONG)
                                .show()
                        else
                            Toast
                                .makeText(context, " Removed from Favourite", Toast.LENGTH_LONG)
                                .show()
                    }
            ) {
                val transition = updateTransition(targetState = isClicked.value, label = "is Clicked")
                val tint by transition.animateColor(label = "isClicked") { isChecked ->
                    if (isChecked) Color.Red else Color.Black
                }
                Icon(
                    imageVector = if (isClicked.value) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                    contentDescription =  "favourite",
                    tint = tint,
                    modifier = Modifier
                        .width(30.dp)
                        .height(30.dp)
                )
            }
        }
        }
}

@Composable
fun MainContent(){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.offset(
            x = 100.dp,
            y = 170.dp
        )
    ) {
        Column{


        }
    }
}

