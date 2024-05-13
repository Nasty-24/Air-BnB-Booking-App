package com.example.airbnbbookingapp.ui.theme.screens.Welcome


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.airbnbbookingapp.R
import com.example.airbnbbookingapp.components.CButton
import com.example.airbnbbookingapp.components.DontHaveAccountRow

@Composable
fun WelcomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier)
{
    Box (modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.me),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
                .matchParentSize())

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ){

            Text(text = "WELCOME",
                fontSize = 32.sp,
                fontWeight = FontWeight(900),
                color = Color.Black,
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.weight(0.1f))
            Text(text = "Book, Stay and Enjoy.\nLive a Life to Remember.",
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight(300),
                color = Color.Black
            )

            Spacer(modifier = Modifier.weight(1f))

            CButton(text = "Sign In With Email",
                onClick = {
                    navController.navigate("signin")

                })

            DontHaveAccountRow(
                onSignUpTap = {
                    navController.navigate("signup")
                }
            )
        }

    }

}
@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen(rememberNavController())
}