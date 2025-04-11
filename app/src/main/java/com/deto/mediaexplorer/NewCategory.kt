package com.deto.mediaexplorer

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewCategory( navController: NavController){

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(stringResource(R.string.newcategory_title),stringResource(R.string.newcategory_subtitle))}

    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 40.dp)
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    value = title,
                    isError = error,
                    onValueChange = { title = it },
                    label = { Text("Title") },
                    placeholder = { Text("Title")}

                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    value = description,
                    isError = error,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    placeholder = { Text("Description")}

                )



            }



        }
    }

}

