package com.example.airbnbbookingapp.ui.theme.screens.GuestDashboard

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.airbnbbookingapp.R

@Composable
fun GuestDashBoardScreen(
    navController: NavHostController
) {


    Image(
        painter = painterResource(id = R.drawable.guest),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.guesty),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)


                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))


        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            ElevatedButton(onClick = {
                navController.navigate("view rooms")

            },
                colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                Text(
                    text = "View Rooms",
                    color = Color.Black
                )
            }
            ElevatedButton(onClick = {
                navController.navigate("booking")

            },
                colors = ButtonDefaults.buttonColors(Color.White)
                ) {
                Text(
                    text = "Book a Room",
                    color = Color.Black
                )
            }
            val mContext = LocalContext.current
            ElevatedButton(
                onClick = {
                    val callIntent = Intent(Intent.ACTION_DIAL)
                    callIntent.data = "tel:0794774699".toUri()
                    mContext.startActivity(callIntent)
                },
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = "Call Owner",
                    color = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(20.dp))


        }
    }
}

    @Preview(showSystemUi = true, showBackground = true)
    @Composable
    fun GuestDashBoardScreePreview() {
        GuestDashBoardScreen(rememberNavController())
    }



