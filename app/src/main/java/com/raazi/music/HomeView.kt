package com.raazi.music

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeView() {
    val categories = listOf("Hits", "Happy", "Workout", "Running", "TGIF", "Yoga")
    val grouped = listOf<String>("New Release", "Favorites", "Top Rated")
   LazyColumn {
       grouped.forEach {
           stickyHeader { Text(text = it, modifier = Modifier.padding(16.dp))
           LazyRow {
               items(categories){
                cat ->
                   BrowserItem(cat, R.drawable.baseline_apps_24)
               }
           }
           }
       }

   }
}


@Composable
fun BrowserItem(cat: String, @DrawableRes drawable:Int){
    Card(
        Modifier
            .padding(16.dp)
            .size(200.dp), border = BorderStroke(3.dp, Color.DarkGray)) {
        Column(Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = cat)
            Image(painter = painterResource(id = drawable), contentDescription = cat)


        }
    }

}