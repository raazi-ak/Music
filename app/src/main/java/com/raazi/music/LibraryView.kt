package com.raazi.music

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

data class Library(@DrawableRes val icon: Int, val name: String)

val libraries = listOf<Library>(
    Library(R.drawable.ic_microphone, "Artists"),
    Library(R.drawable.ic_playlist_green, "Playlists"),
    Library(R.drawable.ic_baseline_album_24, "Albums"),
    Library(R.drawable.ic_baseline_music_note_24, "Songs"),
    Library(R.drawable.ic_genre, "Genre")


)


@Composable
fun LibraryView(){
    LazyColumn {
        items(libraries){
            item -> LibItem(lib = item)
        }
    }
}

@Composable
fun LibItem(lib: Library){
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Icon(painter = painterResource(id = lib.icon), contentDescription = lib.name)
                Spacer(modifier = Modifier.padding(3.dp))
                Text(text = lib.name)
            }
            Row {
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, null)

            }

        }
        HorizontalDivider()
    }
}