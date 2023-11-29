package com.example.introtocompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardElevation
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.introtocompose.ui.theme.IntroToComposeTheme
import com.example.introtocompose.ui.theme.Orange
import com.example.introtocompose.ui.theme.White
import com.example.introtocompose.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IntroToComposeTheme {
                // A surface container using the 'background' color from the theme
                MyApps()
            }
        }
    }
}

@Composable
fun MyApps(){

    val moneyCounter = remember {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = Color(0xFF205375)
    ){
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CreateCircle(moneyCounter = moneyCounter.value){newValue ->
                moneyCounter.value = newValue
            }
            CreateCircleMin(moneyCounter = moneyCounter.value){newValue ->
                moneyCounter.value = newValue
            }

        }
        Column {
            TopComp()
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Rp.${moneyCounter.value}.,", style = TextStyle(
                color = Orange,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold

            ))
            Spacer(modifier = Modifier.height(155.dp))
            
//            Spacer(modifier = Modifier.height(10.dp))
            if (moneyCounter.value >= 100000){
                Text(text = "Lots of Money", color = Orange)
            }else if(moneyCounter.value >= 50000){

            }else{
                Text(text = "Saving!!!", color = Orange)
            }
        }
    }
}
@Composable
fun CreateCircle(moneyCounter: Int = 0,
                 updateMoneyCounter: (Int) -> Unit ) {


    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                updateMoneyCounter(moneyCounter + 10000)
            },
        shape = CircleShape,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Tambah")
        }

    }
}

@Composable
fun CreateCircleMin(
    moneyCounter: Int = 0,
    updateMoneyCounter: (Int) -> Unit
                    ){
    Card (
        modifier = Modifier
            .padding(3.dp)
            .size(105.dp)
            .clickable {
                updateMoneyCounter(moneyCounter - 10000)
            },
        shape = CircleShape,
    ) {
        Box (
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Text(text = "Kurang")
        }
    }
}

@Composable
fun TextComp(text: String, size: Double, textColor: Color = White, modifier: Modifier = Modifier) {
    Text(text = text, fontSize = size.sp, color = textColor, modifier = modifier)
}

@Composable
fun TopComp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 131.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(74.dp)
                .height(61.dp),
            painter = painterResource(id = com.example.introtocompose.R.drawable.lg_pugin),
            contentDescription = "Logo Plugin"
        )
        TextComp(text = "PLUG-IN", size = 24.0, textColor = White)
        Text(text = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = White,
                    fontSize = 16.sp
                )
            ) {
                append("Learn from ")
            }
            withStyle(
                style = SpanStyle(
                    color = Orange,
                    fontSize = 16.sp
                )
            ) {
                append(" anything")
            }
            withStyle(
                style = SpanStyle(
                    color = White,
                    fontSize = 16.sp
                )
            ) {
                append(" and")
            }
            withStyle(
                style = SpanStyle(
                    color = Orange,
                    fontSize = 16.sp
                )
            ) {
                append(" anywhere")
            }
        })
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApps()
}