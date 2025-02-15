package com.ken.jetpackcomposeproject

import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ken.jetpackcomposeproject.ui.theme.JetpackComposeProjectTheme
import java.util.Locale

class GoogleAsisstanceActivity : ComponentActivity() {
    lateinit var startForActivity: ActivityResultLauncher<Intent>
    var speakText by mutableStateOf("")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startForActivity = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == RESULT_OK) {
                var result = it.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                speakText = result?.get(0).toString()
                Log.d("GoogleAssitance", "result: $speakText")

            }
        }

        enableEdgeToEdge()
        setContent {
            JetpackComposeProjectTheme {
                SpeechToText()
            }
        }
    }

    @Composable
    fun SpeechToText() {
        var context = LocalContext.current
        Box(modifier = Modifier.fillMaxSize())
        {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            )
            {
                IconButton(onClick = {
                    val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    intent.putExtra(
                        RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                    )
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak to text")
                    startForActivity.launch(intent)
                })
                {
                    Icon(Icons.Rounded.Add, contentDescription = "Add")
                }
                Text(text = speakText)
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        SpeechToText()
    }
}