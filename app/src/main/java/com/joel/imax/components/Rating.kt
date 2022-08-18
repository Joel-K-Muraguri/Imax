package com.joel.imax.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joel.imax.R

@Composable
fun Rating(){
    Row {
        StarIcon()
        StarIcon()
        StarIcon()
        StarIcon()
        HalfStarIcon()
    }
}

@Composable
fun StarIcon(){
    val star = painterResource(id = R.drawable.ic_baseline_star_24)

    Icon(
        painter = star,
        contentDescription = "star",
        tint = Color.Yellow,
        modifier = Modifier
            .width(16.dp)
            .height(16.dp)
    )

}

@Composable
fun HalfStarIcon(){

    val halfStar = painterResource(id = R.drawable.ic_baseline_star_half_24)
    Icon(
        painter = halfStar,
        contentDescription = "star",
        tint = Color.Yellow,
        modifier = Modifier
            .width(16.dp)
            .height(16.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun RatingPreview(){
    Rating()
}