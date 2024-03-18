package com.raazi.music

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AccountDialog(dialogOpen: MutableState<Boolean>) {
    if (dialogOpen.value) {
        AlertDialog(onDismissRequest = { dialogOpen.value = false }, confirmButton = {
            TextButton(onClick = { dialogOpen.value = false }) {
                Text(text = "Confirm")
            }
            TextButton(onClick = { dialogOpen.value = false }) {
                Text(text = "Dismiss")
            }
        },
            title = { Text(text = "Add Account") },
            text = {
                    Column(
                        Modifier
                            .wrapContentHeight()
                            .padding(top = 16.dp), Arrangement.Center) {
                              TextField(value = "", onValueChange ={

                              },  modifier = Modifier.padding(top =16.dp), 
                                  label = {
                                      Text(text = "Email")
                                  })
                    }
            })
    }
}