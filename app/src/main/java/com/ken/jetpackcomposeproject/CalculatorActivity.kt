package com.ken.jetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ken.jetpackcomposeproject.ui.theme.JetpackComposeProjectTheme

class CalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeProjectTheme {

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Calculator() {
    var value1 by remember {
        mutableStateOf(
            ""
        )
    }
    var value2 by remember {
        mutableStateOf(
            ""
        )
    }
    var result by remember {
        mutableStateOf<String>(
            ""
        )
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(Color.Cyan)
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth().wrapContentSize()
                .padding(16.dp).shadow(
                    elevation = 10.dp,
                    spotColor = Color.Blue,
                    shape = RoundedCornerShape(10.dp)
                ),
            color = Color.White,
            shadowElevation = 10.dp,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                modifier = Modifier.wrapContentSize().padding(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Calculator", modifier = Modifier.padding(bottom = 30.dp).fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 28.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        shadow = Shadow(
                            color = Color.Blue,
                            blurRadius = 10f
                        ),
                        textAlign = TextAlign.Center
                    ),
                )

                OutlinedTextField(
                    value = value1,
                    onValueChange = { value1 = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(15.dp))
                OutlinedTextField(
                    value = value2,
                    onValueChange = { value2 = it },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.padding(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ElevatedButton(onClick = {
                        result = (value1.toDouble() + value2.toDouble()).toString()
                    }, modifier = Modifier.weight(1f).fillMaxWidth())
                    {
                        Text(text = "+")
                    }
                    Spacer(modifier = Modifier.padding(horizontal = 15.dp))
                    ElevatedButton(onClick = {
                        result = (value1.toDouble() - value2.toDouble()).toString()

                    }, modifier = Modifier.weight(1f).fillMaxWidth())
                    {
                        Text(text = "-")
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ElevatedButton(onClick = {
                        result = (value1.toDouble() * value2.toDouble()).toString()

                    }, modifier = Modifier.weight(1f).fillMaxWidth())
                    {
                        Text(text = "*")

                    }
                    Spacer(modifier = Modifier.padding(horizontal = 15.dp))
                    ElevatedButton(onClick = {
                        result = (value1.toDouble() / value2.toDouble()).toString()

                    }, modifier = Modifier.weight(1f).fillMaxWidth())
                    {
                        Text(text = "/")

                    }
                }
                if (result.isNotEmpty())
                    Text(text = "Result is: $result")

            }
        }
    }
}
