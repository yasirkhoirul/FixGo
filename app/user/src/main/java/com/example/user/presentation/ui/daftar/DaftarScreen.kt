package com.example.user.presentation.ui.daftar

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.component.Button
import com.example.core.component.field.NumberField
import com.example.core.theme.FixGoTheme
import com.example.user.R
import com.example.core.R as CoreR

@Composable
fun DaftarScreen(modifier: Modifier = Modifier) {
    Scaffold() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it), contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = modifier
                    .background(
                        color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(
                            bottomStart = 10.dp,
                            bottomEnd = 10.dp
                        )
                    )
                    .height(333.dp)
                    .fillMaxWidth()
                    .align(Alignment.TopCenter),

                )
            Column(
                modifier = Modifier.padding(horizontal = 25.dp),
                verticalArrangement = Arrangement.spacedBy(
                    32.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(
                        space = 16.dp,
                        alignment = Alignment.CenterVertically
                    )
                ) {
                    Surface(
                        modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp),
                        shadowElevation = 4.dp,
                        shape = RoundedCornerShape(28.dp),
                        color = MaterialTheme.colorScheme.surface
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(horizontal = 20.dp, vertical = 8.dp)
                                .height(60.dp)
                                .width(41.dp),
                            painter = painterResource(R.drawable.image),
                            contentDescription = null,
                        )
                    }
                    Text(
                        "Daftar ke FixGo",
                        style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Text(
                        "Mulai rawat kendaraanmu dengan mudah dan nikmati perjalanan yang lebih aman.",
                        style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.SemiBold),
                        color = MaterialTheme.colorScheme.secondary, textAlign = TextAlign.Center
                    )
                }
                Surface(
                    shadowElevation = 4.dp,
                    shape = RoundedCornerShape(14.dp),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 14.dp),
                        verticalArrangement = Arrangement.spacedBy(
                            space = 20.dp
                        )
                    ) {
                        NumberField(placeHolder = "Masukkan nomor telepon")
                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {}
                        ) {
                            Text("Daftar")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(58.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(
                        space = 90.dp,
                        alignment = Alignment.CenterVertically
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        verticalArrangement = Arrangement
                            .spacedBy(space = 28.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            HorizontalDivider(modifier = Modifier.weight(1f))
                            Text(
                                text = "Daftar dengan metode lain",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            HorizontalDivider(modifier = Modifier.weight(1f))
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(
                                16.dp,
                                Alignment.CenterHorizontally
                            )
                        ) {
                            val socialIcons = listOf(
                                CoreR.drawable.fb,
                                CoreR.drawable.apple,
                                CoreR.drawable.google
                            )
                            socialIcons.forEach { icon ->
                                Surface(
                                    shape = CircleShape,
                                    shadowElevation = 2.dp,
                                    modifier = Modifier.size(50.dp),
                                    onClick = {}
                                ) {
                                    Box(contentAlignment = Alignment.Center) {
                                        Image(
                                            painter = painterResource(id = icon),
                                            contentDescription = null,
                                            modifier = Modifier.size(24.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Sudah punya akun ?",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Text(
                            text = "Masuk disini",
                            style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable { }
                        )
                    }
                }
            }


        }

    }
}

@Preview
@Composable
private fun DaftarScreenPrev() {
    FixGoTheme {
        DaftarScreen()
    }
}