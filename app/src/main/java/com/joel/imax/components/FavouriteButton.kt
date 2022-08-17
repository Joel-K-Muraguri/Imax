package com.joel.imax.components

import android.widget.Toast
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.IconToggleButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun FavouriteButton(){
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
           modifier = Modifier.clickable {
               if (isClicked.value != isClicked.value)
                   Toast.makeText(context, " Added to Favourite" , Toast.LENGTH_LONG).show()
               else
                   Toast.makeText(context, " Removed from Favourite" , Toast.LENGTH_LONG).show()
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

           )
       }

}