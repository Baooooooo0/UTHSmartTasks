package com.example.uthsmarttasks.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.uthsmarttasks.Footer
import com.example.uthsmarttasks.R
import com.example.uthsmarttasks.sign_in.AuthViewModel
import kotlinx.coroutines.launch

@Composable
fun AuthScreen(
    navController: NavController,  // Accept navController
    viewModel: AuthViewModel = viewModel(factory = AuthViewModel.Factory),
    onSignInSuccess: () -> Unit = {}
) {
    val context = LocalContext.current
    val user by viewModel.user.collectAsStateWithLifecycle()
    val isLoading by viewModel.isLoading.collectAsStateWithLifecycle()
    val signInError by viewModel.signInError.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // Handle sign-in success
    LaunchedEffect(user) {
        user?.let {
            onSignInSuccess()
        }
    }

    LaunchedEffect(signInError) {
        signInError?.let { error ->
            coroutineScope.launch {
                snackbarHostState.showSnackbar(error)
            }
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { navController.navigate("profileScreen") },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF42AFFF)
                ),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 5.dp, end = 10.dp)
            ) {
                Text(
                    text = "Profile",
                    fontSize = 20.sp
                )
            }
            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp)
                )
            } else {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    if (user == null) {
                        SignInContent(
                            onSignInClick = { viewModel.signIn() },
                            navController = navController
                        )
                    } else {
                        UserProfileContent(
                            user = user,
                            onSignOutClick = { viewModel.signOut() },
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SignInContent(
    onSignInClick: () -> Unit,
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Button(
            onClick = { navController.navigate("profileScreen") } ,
            modifier = Modifier.align(Alignment.TopStart)
        ) {
            Text("Back")
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 40.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_image),
            contentDescription = "LoginImage",
            modifier = Modifier
                .size(230.dp)
        )
        Text(
            text = "SmartTasks",
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp,
            color = Color(0xFF2196F3),
            modifier = Modifier.padding(top = 20.dp)
        )

        Text(
            text = "A simple and efficient to-do app",
            color = Color(0xFF2196F3),
        )
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 200.dp)
        ){
            Text(
                text = "Welcome",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 23.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Ready to explore? Log in to get started.",
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 20.dp)
                )
            Button(
                onClick = onSignInClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFD5EDFF),
                    contentColor = Color(0xFF130160)
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .width(500.dp)
                    .height(75.dp)
                    .padding(start = 30.dp, end = 30.dp)
            ) {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.icon_google),
                        contentDescription = "Google Icon",
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = " SIGN IN WITH GOOGLE",
                        fontSize = 20.sp,
                    )
                }
            }
        }
    }
}


@Composable
private fun UserProfileContent(
    user: com.google.firebase.auth.FirebaseUser?,
    onSignOutClick: () -> Unit,
    navController: NavController
) {
    val profilePainter = rememberAsyncImagePainter(
        model = user?.photoUrl
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(top = 150.dp)
    ) {
        AsyncImage(
            model = user?.photoUrl,
            contentDescription = "Profile Picture",
            placeholder = profilePainter,
            fallback = profilePainter,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        )

        Text(
            text = "Welcome, ${user?.displayName ?: "User"}",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = user?.email ?: "",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Button(onClick = onSignOutClick) {
            Text("Sign Out")
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(bottom = 0.dp),
        contentAlignment = Alignment.BottomCenter
    ){
        Footer(navController = navController, "taskScreen", "Get Started", showBackButton = false)
    }
}