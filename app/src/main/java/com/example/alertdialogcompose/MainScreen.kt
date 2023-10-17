package com.example.alertdialogcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.alertdialogcompose.ui.theme.orange
import com.example.alertdialogcompose.ui.theme.white

@Composable
fun MainScreen(
    viewModel: MainViewModel
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(
            onClick = {
                viewModel.onBuyClick()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = orange,
                contentColor = white
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            shape = CircleShape
        ) {
            Text(
                text = "Buy",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
    if(viewModel.isDialogShow) {
        CustomDialog(
            onDismiss = {
                        viewModel.onDismissDialog()
            },
            onConfirm = {
                //viewModel.buyItem
                //viewModel.forwardToPaymentMethod
            }
        )
    }
}