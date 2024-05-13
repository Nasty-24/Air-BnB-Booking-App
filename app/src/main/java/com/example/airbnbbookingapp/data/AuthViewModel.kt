package com.example.airbnbbookingapp.data


import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.airbnbbookingapp.models.Users
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthViewModel(var navController: NavController, var context: Context){

    var mAuth:FirebaseAuth
    val progress:ProgressDialog

    init {
        mAuth= FirebaseAuth.getInstance()
        progress=ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait.....")
    }
    fun signup(email:String,pass:String,confpass:String){
//       progress.show()

        if (email.isBlank() || pass.isBlank() ||confpass.isBlank()){
//            progress.dismiss()
            Toast.makeText(context,"Please email and password cannot be blank",Toast.LENGTH_LONG).show()
            return
        }else if (pass != confpass){
            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
            return
        }else{
            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener {
                if (it.isSuccessful){

                    val userdata=Users(email,pass,mAuth.currentUser!!.uid)
                    val regRef=FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {

                        if (it.isSuccessful){
                            Toast.makeText(context,"Signed Up Successfully",Toast.LENGTH_LONG).show()
                            navController.navigate("home")

                        }else{
                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                            navController.navigate("signin")
                        }
                    }
                }else{
                    navController.navigate("signup")
                }

            } }

    }
    fun signin(email: String,pass: String){
        progress.show()

        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                Toast.makeText(context,"Succeffully Signed in",Toast.LENGTH_LONG).show()
                navController.navigate("home")
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            }else{
                Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
                navController.navigate("signin")
            }
        }

    }
    fun logout(){
        mAuth.signOut()
        navController.navigate("signin")
    }
    fun isloggedin():Boolean{
        return mAuth.currentUser !=null
    }

}