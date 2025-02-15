package com.ken.jetpackcomposeproject

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.ken.jetpackcomposeproject.ui.theme.JetpackComposeProjectTheme

class Web2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeProjectTheme {
                WebScreen()
            }
        }
    }
}

@Composable
fun WebScreen() {
    AndroidView(factory = { context ->
        return@AndroidView WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
    },
        update = {
            it.loadUrl("https://www.geeksforgeeks.org/scaffold-in-android-using-jetpack-compose/")
        })
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun WebScreenPreview() {
    WebScreen()
}
