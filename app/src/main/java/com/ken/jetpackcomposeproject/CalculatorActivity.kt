package com.ken.jetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier.fillMaxSize().padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CalculatorPreview() {
    Calculator()
}
