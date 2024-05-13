package com.example.airbnbbookingapp.ui.theme.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.airbnbbookingapp.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {


        val image = painterResource(
            id =
            R.drawable.home
        )
        MediumTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.background,
                titleContentColor = MaterialTheme.colorScheme.background,
            ),
            title = {
                Text("Top app Bar")
            },
            navigationIcon = {
                IconButton(onClick = {}) {

                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { navController.navigate("home") }) {
                    Icon(
                        Icons.Filled.Home,
                        contentDescription = "Home"
                    )
                }



            },

            )


        Box(modifier = Modifier.fillMaxSize())
        {
            Image(
                painter = painterResource(id = R.drawable.home),
                contentDescription = "Background Image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )
        }


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            var context = LocalContext.current
            // var productdata=productviewmodel(navController,context)

            Text(
                text = "Air bnb",
                color = Color.White,
                fontFamily = FontFamily.Cursive,
                fontSize = 50.sp
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Welcome to Home page",
                color = Color.White,
                fontFamily = FontFamily.Cursive,
                fontSize = 50.sp
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Use App as:",
                color = Color.White,
                fontFamily = FontFamily.Cursive,
                fontSize = 50.sp
            )

            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navController.navigate("guest dashboard")
            }, modifier = Modifier.fillMaxWidth().padding(50.dp)) {
                Text(text = "Guest")
            }

            Spacer(modifier = Modifier.height(50.dp))
            Button(onClick = {
                navController.navigate("owner-dashboard")
            }, modifier = Modifier.fillMaxWidth().padding(50.dp)) {
                Text(text = "Owner")
            }
        }
    }

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}