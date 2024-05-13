package com.example.airbnbbookingapp.ui.theme.screens.OwnerDasboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.airbnbbookingapp.R

@Composable
fun OwnerDashBoardScreen(
    navController: NavHostController
){
        val image = painterResource(
            id =
            R.drawable.owner
        )
    Image(painter = painterResource(id = R.drawable.guest),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize())
     Column (modifier = Modifier.fillMaxSize(),
         horizontalAlignment = Alignment.CenterHorizontally
     ){


         Image(
             painter = image,
             contentDescription = null,
             modifier = Modifier
                 .size(150.dp)
                 .clip(CircleShape),
             contentScale = ContentScale.Crop
         )



         Spacer(modifier = Modifier.height(20.dp))
         Row() {
             ElevatedButton(onClick = {
                 navController.navigate("add rooms")

             },
                 colors = ButtonDefaults.buttonColors(Color.White)
                 ) {
                 Text(text = "Add Rooms",
                     color = Color.Black)
             }
             ElevatedButton(onClick = {
                 navController.navigate("view rooms")

             },
                 colors = ButtonDefaults.buttonColors(Color.White)
                 ) {
                 Text(text = "View Rooms",
                     color = Color.Black)
             }

         }
     }
    }



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OwnerDashBoardScreenPreview(){
    OwnerDashBoardScreen(rememberNavController())
}