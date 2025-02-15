package com.ken.jetpackcomposeproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ken.jetpackcomposeproject.ui.theme.JetpackComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeProjectTheme {
                LoginUI()
            }
        }
    }
}

@Composable
fun LoginUI() {
    val context = LocalContext.current
    var email: String by remember { mutableStateOf("") }
    var password: String by remember { mutableStateOf("") }
    Box(modifier = Modifier.background(Color.Cyan).fillMaxSize()) {
        Box(
            modifier = Modifier
                .padding(28.dp)
                .alpha(0.7f)
                .clip(
                    CutCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp,
                        bottomStart = 10.dp,
                        bottomEnd = 10.dp
                    )
                )
                .wrapContentHeight()
                .background(MaterialTheme.colorScheme.background)
                .align(Alignment.Center)
        ) {
            Column(
                modifier = Modifier.padding(32.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
//        Box(
//            modifier = Modifier.background(Color.Cyan),
//        ) {
                Text(
                    modifier = Modifier.padding(horizontal = 20.dp),
                    text = "Login UI",
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp
                )
//        }
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.height(200.dp).width(200.dp)
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                OutlinedTextField(
                    value = email, onValueChange = { email = it },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                    placeholder = { Text(text = "E-Mail") }
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                    placeholder = { Text(text = "Password") }
                )
                Spacer(
                    modifier = Modifier.height(20.dp)
                )
                OutlinedButton(onClick = {
                    Toast.makeText(context, "Login Successfully", Toast.LENGTH_SHORT).show()
                })
                {
                    Text(text = "Login")
                }
            }
        }

    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginUIPreview() {
    LoginUI()
}