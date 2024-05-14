package com.example.airbnbbookingapp.ui.theme.screens.Rooms

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.airbnbbookingapp.data.RoomViewModel



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRoomsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Add Rooms",
            fontSize = 40.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.White,
            modifier = Modifier.padding(30.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var location by remember { mutableStateOf(TextFieldValue("")) }
        var bedrooms by remember { mutableStateOf(TextFieldValue("")) }
        var roomprice by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text(text = "Location:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = bedrooms,
            onValueChange = { bedrooms = it },
            label = { Text(text = "BedRooms:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = roomprice,
            onValueChange = { roomprice = it },
            label = { Text(text = "Price:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))
        //---------------------IMAGE PICKER START-----------------------------------//

        ImagePicker(Modifier,context, navController, location.text.trim(), bedrooms.text.trim(), roomprice.text.trim())


    }
}
@Composable
fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, location:String, bedrooms:String, roomprice:String) {
    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier,) {
        if (hasImage && imageUri != null) {
            val bitmap = MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    imagePicker.launch("image/*")
                },
            ) {
                Text(
                    text = "Select Image"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
                var roomsRepository = RoomViewModel(navController, context)
                roomsRepository.saveProductWithImage(location, bedrooms, roomprice, imageUri!!)
                navController.navigate("add rooms")

            }) {
                Text(text = "Upload")
            }
            Spacer(modifier = Modifier.height(20.dp))
//
//            Button(onClick = {
//                RoomRepository.deleteRoom(id)
//            }) {
//                Text(text = "Delete")
//            }
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Button(onClick = {
//                navController.navigate(""+"/$id")
//            }) {
//                Text(text = "Update")
//            }
        }
    }
}
@Preview
@Composable
fun AddRoomsScreenPreview(){
    AddRoomsScreen( rememberNavController())

}
