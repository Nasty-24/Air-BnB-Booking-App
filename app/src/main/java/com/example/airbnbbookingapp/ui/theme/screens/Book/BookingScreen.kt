package com.example.airbnbbookingapp.ui.theme.screens.Book

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun BookingScreen(
    navController: NavHostController
) {
    var name by remember { mutableStateOf(TextFieldValue()) }
    var streetAddress by remember { mutableStateOf(TextFieldValue()) }
    var city by remember { mutableStateOf(TextFieldValue()) }
    var postalCode by remember { mutableStateOf(TextFieldValue()) }
    var country by remember { mutableStateOf(TextFieldValue()) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var phone by remember { mutableStateOf(TextFieldValue()) }
    var checkIn by remember { mutableStateOf(TextFieldValue()) }
    var checkOut by remember { mutableStateOf(TextFieldValue()) }
    var roomNumber by remember { mutableStateOf(TextFieldValue()) }
    var specialRequests by remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )
        val mContext = LocalContext.current
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("City") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = checkIn,
            onValueChange = { checkIn = it },
            label = { Text("Check-in Date") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = checkOut,
            onValueChange = { checkOut = it },
            label = { Text("Check-out Date") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = roomNumber,
            onValueChange = { roomNumber = it },
            label = { Text("Room Number") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            modifier = Modifier.padding(50.dp),
            value = specialRequests,
            onValueChange = { specialRequests = it },
            label = { Text("Special Requests ") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("paying") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Book")

        }


    }


    }


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BookingPagePreview() {
    BookingScreen( rememberNavController())
}