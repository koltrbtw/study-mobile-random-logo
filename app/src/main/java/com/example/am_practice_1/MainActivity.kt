package com.example.am_practice_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.am_practice_1.ui.theme.AMPractice1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AMPractice1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MobileLogo()
                }
            }
        }
    }
}

@Composable
@Preview
fun MobileLogo() {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var mobile by remember { mutableStateOf( 1) }
        val drawable = when(mobile) {
            1 -> R.drawable.apple
            2 -> R.drawable.google
            3 -> R.drawable.htc
            4 -> R.drawable.microsoft
            5 -> R.drawable.motorola
            6 -> R.drawable.nokia
            7 -> R.drawable.oppo
            8 -> R.drawable.samsung
            9 -> R.drawable.sony
            else -> R.drawable.xiaomi
        }

        Image(
            modifier = Modifier.width(200.dp)
                               .padding(vertical = 10.dp),
            painter = painterResource(id = drawable),
            contentDescription = null
        )

        Button(onClick = { mobile = (1..10).random() }) {
            Text("Сменить телефон")
        }
    }
}