package com.ken.jetpackcomposeproject

import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.ken.jetpackcomposeproject.ui.theme.JetpackComposeProjectTheme

class CameraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var imageBitmap by remember {
                mutableStateOf<Bitmap?>(null)
            }
            val cameraLauncher =
                rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicturePreview()) {
                    imageBitmap = it
                }
            var permissionLauncher =
                rememberLauncherForActivityResult(contract = ActivityResultContracts.RequestPermission())
                {
                    if (it) {
                        cameraLauncher.launch(null)
                    }
                }
            JetpackComposeProjectTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                )
                {
                    var context = LocalContext.current
                    TextButton(onClick = {
                        if (ContextCompat.checkSelfPermission(
                                context,
                                android.Manifest.permission.CAMERA
                            ) == PackageManager.PERMISSION_GRANTED
                        ) {
                            cameraLauncher.launch(null)
                        } else {
                            permissionLauncher.launch(android.Manifest.permission.CAMERA)
                        }
                    }) {
                        Text(text = "Use Camera")
                    }
                    imageBitmap.let {
                        if (it != null) {
                            Image(bitmap = it.asImageBitmap(), contentDescription = null, modifier =
                            Modifier.width(300.dp).height(250.dp))
                        }
                    }
                }

            }
        }
    }
}
