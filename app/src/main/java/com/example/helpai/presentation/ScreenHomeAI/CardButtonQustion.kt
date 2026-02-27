package com.example.helpai.presentation.ScreenHomeAI

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardButtonQustion(

    text: String,
    onClick: () -> Unit

){

    Box(
        modifier = Modifier
            .background(
                color = Color(0xB91E1E1E),
                shape = RoundedCornerShape(14.dp)
            )
            .border(
                width = 1.dp,
                color = Color.Gray.copy(alpha = 0.1f),
                shape = RoundedCornerShape(14.dp)
            )
            .clickable { onClick() }
            .padding(vertical = 14.dp, horizontal = 12.dp)
            .widthIn(max = 150.dp)
            .height(60.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.wrapContentWidth()
        ) {
            Icon(
                imageVector = Icons.Default.Lightbulb,
                contentDescription = null,
                tint = Color(0xFF4B14A4),
                modifier = Modifier.size(18.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = text,
                color = Color.White,
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }


}