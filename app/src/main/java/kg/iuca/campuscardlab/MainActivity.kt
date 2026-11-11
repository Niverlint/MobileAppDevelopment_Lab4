package kg.iuca.campuscardlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kg.iuca.campuscardlab.ui.theme.CampusCardLabTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusCardLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CampusCard(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CampusCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Title Block
        Text(
            text = "Campus Card",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Student ID: 12345",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(24.dp))

        //Schedule
        Text(
            text = "Today",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))


        Greeting(
            words = listOf("ANDROID", "KOTLIN", "COMPOSE", "LAYOUT")
        )

        Spacer(modifier = Modifier.weight(1f))

        //Buttons
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { }) {
                Text("Map")
            }
            Button(onClick = { }) {
                Text("Show QR")
            }
        }
    }
}

@Composable
fun Greeting(words: List<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        words.forEachIndexed { rowIndex, word ->
            val isEvenRow = (rowIndex + 1) % 2 == 0

            val rowBackgroundColor = if (isEvenRow) {
                Color.LightGray
            } else {
                MaterialTheme.colorScheme.primaryContainer
            }

            val highlightedIndices = remember(rowIndex, word) {
                if (isEvenRow) {
                    val countToHighlight = Random.nextInt(1, (word.length / 2).coerceAtLeast(2))
                    List(word.length) { it }.shuffled().take(countToHighlight).toSet()
                } else {
                    emptySet()
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(rowBackgroundColor)
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                word.forEachIndexed { letterIndex, char ->
                    val boxColor = if (isEvenRow && highlightedIndices.contains(letterIndex)) {
                        Color.Yellow
                    } else if (isEvenRow) {
                        Color.Transparent
                    } else {
                        MaterialTheme.colorScheme.primary
                    }

                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .background(boxColor),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = char.toString(),
                            fontSize = 16.sp,
                            color = if (boxColor == Color.Yellow) Color.Black else Color.White
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CampusCardPreview() {
    CampusCardLabTheme {
        CampusCard()
    }
}