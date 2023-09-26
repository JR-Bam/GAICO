package com.example.gaico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gaico.ui.theme.GAICOTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GAICOTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Menu()
                }
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun Menu(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .background(Color.Green)){
        Image(
            painter = painterResource(R.drawable.main_menu_bg),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .blur(radius = 11.dp)
                .fillMaxSize()
        )

        var colorState by remember { mutableStateOf(Color(0x8F008BC2))}

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "GAIGO",
                style = TextStyle(
                    fontSize = 160.sp,
                    fontFamily = FontFamily(Font(R.font.caveat_bold)),
                    fontWeight = FontWeight(400),
                    color = colorState,
                    shadow = Shadow(
                        offset = Offset(5.0f, 10.0f),
                        blurRadius = 20.0f,
                        color = Color.White
                    )
                )
            )
            Spacer(Modifier.height(50.dp))

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(300.dp)
                    .clickable{
                        val color = Color(
                            red = Random.nextFloat(),
                            blue = Random.nextFloat(),
                            green = Random.nextFloat(),
                            alpha = 1.0f
                        )
                        colorState = color
                    }
            ) {
                val infiniteTransition = rememberInfiniteTransition()
                val angle by infiniteTransition.animateFloat(
                    initialValue = 0F,
                    targetValue = 360F,
                    animationSpec = infiniteRepeatable(
                        animation = tween(20000, easing = LinearEasing)
                    )
                )
                Image(
                    painter = painterResource(R.drawable.star_1),
                    contentDescription = "button_bg",
                    modifier = Modifier
                        .fillMaxSize()
                        .rotate(angle)
                )

                val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Green)
                Text (
                    text = "Juga",
                    style = TextStyle(
                        fontSize = 80.sp,
                        fontFamily = FontFamily(Font(R.font.indieflower_regular)),
                        brush = Brush.horizontalGradient(colors = gradientColors),
                        shadow = Shadow(
                            offset = Offset(5.0f, 5.0f),
                            blurRadius = 10.0f,
                            color = Color.Black
                        )
                    )
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GAICOTheme {
        Menu()
    }
}