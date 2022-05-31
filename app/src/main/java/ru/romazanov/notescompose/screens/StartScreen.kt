package ru.romazanov.notescompose.screens

import android.window.SplashScreen
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import ru.romazanov.notescompose.MainVM
import ru.romazanov.notescompose.navigation.Screen
import ru.romazanov.notescompose.ui.ButtonDefault
import ru.romazanov.notescompose.utils.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StartScreen(
    navHostController: NavHostController,
    viewModel: MainVM
) {

    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "Авторизация/Регистрация",
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.padding(16.dp))
                OutlinedTextField(
                    label = { Text("Логин") },
                    value = login,
                    onValueChange = { login = it },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                OutlinedTextField(
                    label = { Text("Пароль") },
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                Button(
                    modifier = Modifier.padding(start = 16.dp),
                    enabled = login.isNotEmpty() && password.isNotEmpty(),
                    onClick = {
                        LOGIN = login
                        PASSWORD = password
                        viewModel.initialDatabase(TYPE_FIREBASE) {
                            println("$login $password") //q@m.ru qwerty
                            navHostController.navigate(Screen.MainScreen.route)
                        }
                    },
                ) {
                    Text("Авторизация")
                }
                Spacer(modifier = Modifier.padding(24.dp))

            }

        }) {

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.surface
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = Constants.Keys.START_SCREEN_QUESTION,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                ButtonDefault(
                    onClick = {
                        viewModel.initialDatabase(TYPE_ROOM) {
                            TYPE_DB = TYPE_ROOM
                            navHostController.navigate(Screen.MainScreen.route)
                        }
                    },
                    text = Constants.Keys.ROOM_DATABASE
                )
                ButtonDefault(
                    onClick = {
                        TYPE_DB = TYPE_FIREBASE
                        coroutineScope.launch {
                            bottomSheetState.show()
                        }
                    },
                    text = Constants.Keys.FIREBASE_DATABASE
                )
            }
        }

    }

}