package com.raazi.music


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()


    androidx.compose.material.Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Home") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }

                    }) {
                        Icon(Icons.Default.AccountCircle, null)
                    }
                }

            )
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            LazyColumn(modifier = Modifier.padding(16.dp)) {
                items(screensInDrawer){ item ->
                          DrawerItem(selected = , item = item ) {

                          }
                }
            }
        }

    ) {
            Text(text = "Text", modifier = Modifier.padding(it))
    }
}


@Composable
fun DrawerItem(
    selected: Boolean,
    item: Screen.DrawerScreen,
    onDrawerItemClicked: () -> Unit,

){
    val background = if(selected) Color.DarkGray else Color.White
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .background(background)
                .clickable {
                    onDrawerItemClicked()
                }
        ){
          Icon(painter = painterResource(id = item.icon), contentDescription = item.dTitle,
              modifier = Modifier.padding(end = 8.dp, top = 4.dp))
            Text(text = item.dTitle,
                style = MaterialTheme.typography.headlineMedium)
        }
}