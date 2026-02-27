package com.example.helpai.presentation.ScreenHomeAI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.R
import com.example.helpai.ui.theme.Gradient


@Composable
fun CardResponsAI(

    textUI: List<ModelsDomain>,
    timeServer: String

){

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 40.dp),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black),
    ){


        Row (
            modifier = Modifier
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)


        ){
            Box(
                modifier = Modifier.background(Gradient.colorServer, shape = RoundedCornerShape(20.dp))
                    .padding(3.dp)

            ){
                Icon(
                    painter = painterResource(R.drawable.robot),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = Color.Unspecified
                )

            }

            Column (
                modifier = Modifier.border(width = 1.dp, color = Color.Gray.copy(alpha = 0.5f), shape = RoundedCornerShape(20.dp))
                    .weight(1f)
                    .background((Color(0xB91E1E1E)), shape = RoundedCornerShape(20.dp))
                    .padding(12.dp),

            ){

                Text(text = textUI.joinToString { it.textDomain },
                    color = Color.White,
                    modifier = Modifier.padding(7.dp),
                    lineHeight = 22.sp,
                    fontSize = 16.sp

                    )


                Text(
                    text = timeServer,
                    color = Color.White,
                    modifier = Modifier.padding(6.dp),
                    fontSize = 12.sp
                )
            }


        }


    }

}