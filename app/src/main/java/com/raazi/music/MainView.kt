package com.raazi.music


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(){

    val controller: NavController = rememberNavController()
    val viewModel:MainViewModel = viewModel()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute= navBackStackEntry?.destination?.route
    val currentScreen = remember{
        viewModel.currentScreen.value
    }
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val scope: CoroutineScope = rememberCoroutineScope()

    val title = remember{
        mutableStateOf(currentScreen.title)
    }
    val dialogOpen = remember {
        mutableStateOf(false)
    }
    androidx.compose.material.Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = title.value) },
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
                          DrawerItem(selected = currentRoute == item.dRoute, item = item ) {
                              viewModel.setCurrentScreen(currentScreen)
                            scope.launch {
                                scaffoldState.drawerState.close()

                            }
                              if(item.dRoute== "add_account"){
                                  dialogOpen.value = true
                              }else{
                                  controller.navigate(item.dRoute)
                                  title.value = item.dTitle
                              }
                          }
                }
            }
        }

    ) {
            Navigation(navController = controller, viewModel = viewModel, pd = it)
        AccountDialog(dialogOpen = dialogOpen)
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

@Composable
fun Navigation(navController: NavController, viewModel: MainViewModel, pd:PaddingValues){
    NavHost(navController = navController as NavHostController , startDestination = Screen.DrawerScreen.Account.route, modifier = Modifier.padding(pd)) {
       
        composable(Screen.DrawerScreen.Subscription.route){
            SubscriptionView()
        }
        composable(Screen.DrawerScreen.Account.route){
            AccountView()
        }


        
    }
        
    
}