package com.example.core.component.field

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.component.Validators
import com.example.core.theme.FixGoTheme

@Composable
fun NumberField(modifier: Modifier = Modifier, placeHolder: String) {
    var text by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }
    val isError = errorMessage != null

    // Using layout from 'pasted image 3': separate box for +62 and input field
    // Background color: Light Grey (Secondary100 or similar)
    val containerColor = Color(0xFFF1F5F9) // Manually setting closer to screenshot if theme differs, or use MaterialTheme.colorScheme.secondaryContainer

    Column(modifier = modifier.wrapContentHeight()) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Indonesia Flag & Code Box (+62)
            Row(
                modifier = Modifier
                    .height(56.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(containerColor)
                    .border(
                        width = if (isError) 1.dp else 0.dp,
                        color = if (isError) MaterialTheme.colorScheme.error else Color.Transparent,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.codeindo),
                    contentDescription = "Indonesia Flag",
                    modifier = Modifier
                        .width(30.dp)
                        .height(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "+62",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }

            // Phone Number Input Field
            OutlinedTextField(

                value = text,
                onValueChange = { newText ->
                    if (newText.all { it.isDigit() }) {
                        text = newText
                        val validation = Validators.validatePhone(text)
                        errorMessage = validation.errorMessage
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .border(
                        width = if (isError) 1.dp else 0.dp,
                        color = if (isError) MaterialTheme.colorScheme.error else Color.Transparent,
                        shape = RoundedCornerShape(12.dp)
                    ),
                placeholder = {
                    Text(placeHolder, color = Color.Gray)
                },
                singleLine = true,
                isError = isError,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = containerColor,
                    unfocusedContainerColor = containerColor,
                    errorContainerColor = containerColor,

                    // Hilangkan border bawaan saat normal
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent,

                    // Border akan otomatis jadi merah saat parameter isError = true
                    errorBorderColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = RoundedCornerShape(12.dp)
            )
        }

        // Error Message
        if (isError) {
            Text(
                text = errorMessage ?: "",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 108.dp, top = 4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun NumberFieldPrev() {
    FixGoTheme {
        Column() {
            NumberField(placeHolder = "Nomor Telpon")
        }
    }

}