package com.raazi.music

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color


@Composable
fun BrowseView(){
    val libCat = listOf<String>("Hip-Hop", "Pop", "EDM", "Soul", "R&B", "Classical")
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
    items(libCat){ cat ->
        BrowseViewItem(cat = cat)
    }            
    }
}

@Composable
fun BrowseViewItem(cat:String){
    Card(
        Modifier
            .padding(16.dp)
            .size(200.dp), border = BorderStroke(width = 3.dp, color = Color.Black)) {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = cat)

        }
    }
}