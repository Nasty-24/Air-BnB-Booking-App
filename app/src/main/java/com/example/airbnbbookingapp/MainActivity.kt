package com.example.airbnbbookingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.airbnbbookingapp.ui.theme.AirBNBBookingAppTheme
import com.example.airbnbbookingapp.ui.theme.screens.Book.BookingScreen
import com.example.airbnbbookingapp.ui.theme.screens.GuestDashboard.GuestDashBoardScreePreview
import com.example.airbnbbookingapp.ui.theme.screens.GuestDashboard.GuestDashBoardScreen
import com.example.airbnbbookingapp.ui.theme.screens.OwnerDasboard.OwnerDashBoardScreen
import com.example.airbnbbookingapp.ui.theme.screens.Rooms.AddRoomsScreen
import com.example.airbnbbookingapp.ui.theme.screens.Rooms.ViewRoomsScreen
import com.example.airbnbbookingapp.ui.theme.screens.Signup.SignUpScreen
import com.example.airbnbbookingapp.ui.theme.screens.Welcome.WelcomeScreen
import com.example.airbnbbookingapp.ui.theme.screens.home.HomeScreen
import com.example.airbnbbookingapp.ui.theme.screens.pay.PayingScreen
import com.example.airbnbbookingapp.ui.theme.screens.signin.SignInScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AirBNBBookingAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavigationView()
                }
            }
        }
    }
}

@Composable
fun NavigationView(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome" ){
        composable("welcome"){ WelcomeScreen(navController)}
        composable("signup"){ SignUpScreen(navController)}
        composable("signin"){ SignInScreen(navController)}
        composable("home"){ HomeScreen(navController)}
        composable("guest dashboard"){ GuestDashBoardScreen(navController)}
        composable("owner-dashboard"){ OwnerDashBoardScreen(navController)}
        composable("add rooms"){ AddRoomsScreen(navController)}
        composable("view rooms"){ ViewRoomsScreen(navController)}
        composable("booking"){ BookingScreen(navController)}
        composable("paying"){ PayingScreen(navController)}


    }

}

