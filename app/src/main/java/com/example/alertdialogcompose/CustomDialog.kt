package com.example.alertdialogcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.alertdialogcompose.ui.theme.orange
import com.example.alertdialogcompose.ui.theme.white

@Composable
fun CustomDialog(
    onDismiss:() -> Unit,
    onConfirm:() -> Unit
) {

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            ),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .fillMaxWidth(0.95f)
                .border(1.dp, color = orange, shape = RoundedCornerShape(15.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                Text(
                    text = "Your selected items. Please select a payment method to continue.",
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Samsung Galaxy S22")
                        Text(text = "779,00$")
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Galaxy S22 Cover Case")
                        Text(text = "32,00$")
                    }
                    Divider()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Total", fontWeight = FontWeight.Bold)
                        Text(text = "831,00$", fontWeight = FontWeight.Bold)
                    }
                    val handler = LocalUriHandler.current
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mastercard),
                            contentDescription = "Klarna",
                            modifier = Modifier
                                .fillMaxWidth(0.2f)
                                .clip(RoundedCornerShape(15.dp))
                                .clickable { handler.openUri("https://www.mastercard.ru/ru-ru.html")  }
                        )
                        Image(
                            painter = painterResource(id = R.drawable.paypal),
                            contentDescription = "Paypal",
                            modifier = Modifier
                                .fillMaxWidth(0.2f)
                                .clip(RoundedCornerShape(15.dp))
                                .clickable { handler.openUri("https://www.paypal.com/ru/home") }
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(30.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = {
                            onDismiss()
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = orange,
                            contentColor = white
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        shape = CircleShape
                    ) {
                        Text(
                            text = "Cancel",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                    Button(onClick = {
                        onConfirm()
                    },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = orange,
                            contentColor = white
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        shape = CircleShape
                    ) {
                        Text(
                            text = "Confirmation",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}


