package com.deto.mediaexplorer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.compose.onPrimaryContainerLight
import com.example.compose.secondaryContainerDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewCategory( navController: NavController, add: (Category)-> Unit){

    var title by remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = secondaryContainerDark,
        contentColor = onPrimaryContainerLight,
        topBar = { TopAppBar(stringResource(R.string.newcategory_title),stringResource(R.string.newcategory_subtitle))},
        bottomBar = {
            BottomAppBar() {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        modifier = Modifier.fillMaxWidth(.7f),
                        onClick = {
                        }
                    ) {
                        Text(stringResource(R.string.newcategory_bottom))
                    }

                    Button(
                        onClick = {

                            error = title.isEmpty()
                            if( !error ){
                                val newCategory = Category(getCategories().size+1,title,null, mutableListOf())

                                add(newCategory)

                                navController.navigate(Home)
                            }
                        },
                        shape = CircleShape,
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "advance",
                            modifier = Modifier.padding(0.dp)
                        )
                    }
                }
            }
        }


    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(horizontal = 40.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                    value = title,
                    leadingIcon = {
                        Icon(
                            painterResource(R.drawable.title_24px),
                            contentDescription = "title",
                            tint = Color.White
                        )
                    },
                    supportingText = { if(error) Text(stringResource(R.string.supportingText_title)) else {} },
                    isError = error,
                    onValueChange = { title = it },
                    label = { Text(stringResource(R.string.form_title)) },
                    placeholder = { stringResource(R.string.form_title) },
                    minLines = 1,
                    maxLines = 1

                )





            }



        }
    }

}

