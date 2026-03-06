package com.example.helpai.presentation.ScreenHomeAI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.helpai.R
import com.example.helpai.presentation.ModelsPresentation.StateIntent
import com.example.helpai.ui.theme.Gradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatUi(

    navController: NavHostController,
    Back: () -> Unit,

    viewModel: AIViewModel = hiltViewModel()

) {
//    val listState = rememberLazyListState()

    val massage by viewModel.state.collectAsState()

//    LaunchedEffect(massage.messagesList.size) {
//        if (massage.messagesList.isNotEmpty()) {
//            listState.animateScrollToItem(massage.messagesList.lastIndex)
//        }
//    }

    //  var text by remember { mutableStateOf("") }

    Scaffold(

        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .background(
                        brush = Gradient.colorServer,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .height(160.dp),

                title = {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                            .padding(top = 45.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(50.dp)
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.White.copy(alpha = 0.2f),
                                            Color.White.copy(alpha = 0.2f)
                                        ),

                                        ),
                                    shape = RoundedCornerShape(15.dp)
                                )

                        ) {
                            Icon(
                                painter = painterResource(R.drawable.starsss),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(49.dp)
                                    .align(Alignment.Center),
                                tint = Color.White

                            )
                        }

                        Column(
                            modifier = Modifier.padding(start = 10.dp)

                        ) {
                            Text(
                                text = "AI Ассистент",
                                fontSize = 20.sp,
                                color = Color.White
                            )

                            Text(
                                text = "Всегда готов помочь",
                                fontSize = 16.sp,
                                color = Color.White.copy(alpha = 0.7f)
                            )
                        }
                    }
                },

                )
        },

        bottomBar = {

            Surface(
                tonalElevation = 4.dp,
                shadowElevation = 10.dp,
                color = Color.Black,
                modifier = Modifier
                    .navigationBarsPadding()

            ) {

                Divider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Gray.copy(alpha = 0.2f),
                    thickness = 1.dp
                )

                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically

                    ) {
                        TextField(
                            value = massage.textField,
                            onValueChange = { viewModel.Chat(StateIntent.Intent.EnterText(it)) },
                            textStyle = TextStyle(
                                fontSize = 14.sp,
                                color = Color.White
                            ),
                            placeholder = {

                                Text(
                                    "Задайте вопрос...",
                                    color = Color.White.copy(alpha = 0.7f),
                                    fontSize = 14.sp
                                )

                            },
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 50.dp, max = 120.dp)
                                .height(50.dp)
                                .padding(start = 15.dp),
                            shape = RoundedCornerShape(15.dp),
                            colors = TextFieldDefaults.colors(
                                unfocusedContainerColor = Color(0x751E1E1E),
                                focusedContainerColor = Color(0x751E1E1E),
                                focusedTextColor = Color.White,
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                cursorColor = Color.White,


                                ),
                            singleLine = true,


                            )

                        Spacer(modifier = Modifier.width(12.dp))

                        IconButton(

                            onClick = { viewModel.Chat(StateIntent.Intent.SendMessage) },
                            enabled = massage.falseButton,
                            modifier = Modifier
                                .size(53.dp)
                                .background(
                                    brush = Gradient.colorServer,
                                    shape = RoundedCornerShape(15.dp)
                                )
                                .alpha(if (massage.falseButton) 1f else 0.4f)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.message),
                                contentDescription = null,
                                tint = Color.White
                            )
                        }
                    }
                }
            }

        }

    ) { paddingValues ->


        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(15.dp)
        ) {

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(15.dp)
                    .padding(top = 10.dp),
                contentPadding = paddingValues,
                verticalArrangement = Arrangement.spacedBy(18.dp),
            ) {

                items(massage.messagesList) { massage ->
                    when (massage) {

                        is ChatMessage.Server -> {
                            CardResponsAI(
                                textUI = massage.textserver,
                                timeServer = massage.currentTime
                            )

                        }

                        is ChatMessage.User -> {
                            CardUserRequst(
                                massageUser = massage.textuser,
                                timeUser = massage.currentTime
                            )

                        }

                        ChatMessage.Typing -> TypingIndicator()
                    }

                }

            }
            if (massage.hideQustion) {

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 100.dp)
                        .navigationBarsPadding()
                ) {

                    Text(text = "Популярные вопросы:",
                        modifier = Modifier.padding(8.dp)
                            .alpha(0.5f),
                        color = Color.White,)


                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CardButtonQustion(
                            text = massage.ListQustion[0],
                            onClick = {
                                viewModel.Chat(
                                    StateIntent.Intent.SelectButton(
                                        massage.ListQustion[0]
                                    )
                                )
                            }
                        )

                        CardButtonQustion(
                            text = massage.ListQustion[1],
                            onClick = {
                                viewModel.Chat(
                                    StateIntent.Intent.SelectButton(
                                        massage.ListQustion[1]
                                    )
                                )
                            }
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        CardButtonQustion(
                            text = massage.ListQustion[2],
                            onClick = {
                                viewModel.Chat(
                                    StateIntent.Intent.SelectButton(
                                        massage.ListQustion[2]
                                    )
                                )
                            }
                        )

                        CardButtonQustion(
                            text = massage.ListQustion[3],
                            onClick = {
                                viewModel.Chat(
                                    StateIntent.Intent.SelectButton(
                                        massage.ListQustion[3]
                                    )
                                )
                            }
                        )
                    }
                }

            }

        }
    }
}





