package com.example.airbnbbookingapp.ui.theme.screens.Signup


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.airbnbbookingapp.R
import com.example.airbnbbookingapp.components.CButton
import com.example.airbnbbookingapp.components.CTextField
import com.example.airbnbbookingapp.components.DontHaveAccountRow

@Composable
fun SignUpScreen(
    navController: NavHostController,
){
        Box (modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = R.drawable.boo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .matchParentSize()

                    )
            Spacer(modifier = Modifier.height(30.dp))

            Column (modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)){
                var Name by remember { mutableStateOf(TextFieldValue("")) }
                var Email by remember { mutableStateOf(TextFieldValue("")) }
                var Password by remember { mutableStateOf(TextFieldValue("")) }



                Column{
                    OutlinedTextField(
                        value = Name, onValueChange = {Name = it},
                        placeholder = { Text(text = "User_Name") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "icon for person") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = Email, onValueChange = {Email = it},
                        placeholder = { Text(text = "Enter_Email") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "icon for person") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = Password, onValueChange = {Password = it},
                        placeholder = { Text(text = "Enter_PassWord") },
                        leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "icon for person") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(onClick = {
                        navController.navigate("signin")
                    },
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "SignUp")
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(onClick = {
                        navController.navigate("signin")
                    },
                        modifier = Modifier.fillMaxWidth()) {
                        Text(text = "Already have an Account? Sign In")
                    }
                }
            }


            }



    }


@Preview
@Composable
fun SignUpScreenPreview(){
    SignUpScreen(rememberNavController())
}
