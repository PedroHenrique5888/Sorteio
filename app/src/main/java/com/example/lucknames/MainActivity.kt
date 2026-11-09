package com.example.lucknames


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            home()
        }
    }
}
@Composable
fun home(){

    val membros = listOf(
        "nabia", "Gabriel", "Lucas", "Pedro", "Gustavo", "Giovana", "Emilly",
        "Alice", "Thalles", "Nikolas", "Prince", "Max", "Rafael", "Gabriela",
        "Lara", "Ruan", "Henrique", "Joyce", "Jean", "João", "Kaique", "Isaac",
        "José", "Breno", "Giulia", "Larissa", "Valtemir"
    )

    var vencedor by remember { mutableStateOf<List<String>>(emptyList()) }

    fun sorteio(){
        val sorteio = membros.shuffled().take(1)
        vencedor = sorteio
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.Crop
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Alunos do Gabriel",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(50.dp)
        )

        Button(onClick = {
            sorteio()
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF009688)
            ),
            modifier = Modifier.padding(0.dp,0.dp,0.dp,20.dp)

        ) {
            Text(text = "Realizar sorteio",
                color = Color.White,
                fontSize = 18.sp
            )
        }
        if(vencedor.isNotEmpty()){
            vencedor.forEachIndexed{ index, vitorioso ->
                Text(
                    text = "Vencedor: ${vitorioso}",
                    fontSize = 18.sp,
                    color = Color(0xFF009688),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }



}
@Preview
@Composable
private fun homePreview(){
    home()
}