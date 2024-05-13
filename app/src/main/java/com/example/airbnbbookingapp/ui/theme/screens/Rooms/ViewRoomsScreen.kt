package com.example.airbnbbookingapp.ui.theme.screens.Rooms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.airbnbbookingapp.models.Upload


import androidx.compose.foundation.lazy.items

import coil.compose.rememberAsyncImagePainter
import com.example.airbnbbookingapp.data.RoomViewModel
import com.example.airbnbbookingapp.models.Rooms


@Composable
fun ViewRoomsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var roomsRepository = RoomViewModel(navController, context)


        val emptyUploadState = remember { mutableStateOf(Upload("","","","","")) }
        var emptyUploadsListState = remember { mutableStateListOf<Upload>() }

        var uploads = roomsRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All Rooms",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(uploads){
                    UploadItem(
                        location = it.locaion,
                        bedrooms = it.bedrooms,
                        roomprice = it.roomprice,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        navController = navController,
                        roomsRepository = roomsRepository
                    )
                }
            }
        }
    }
}






@Composable
fun UploadItem(location:String, bedrooms:String, roomprice:String, imageUrl:String, id:String,
               navController: NavHostController, roomsRepository:RoomViewModel) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = location)
        Text(text = bedrooms)
        Text(text = roomprice)
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )

    }
}






@Preview
@Composable
fun ViewRoomsScreenPreview(){
    ViewRoomsScreen(rememberNavController())
}