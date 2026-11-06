package kg.iuca.campuscardlab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kg.iuca.campuscardlab.ui.theme.CampusCardLabTheme

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

        //EXERCISE 5
        ProfileHeader(
            name = "Amal Asanbekov",
            status = "In class · Building B"
        )

        Spacer(modifier = Modifier.height(24.dp))

        //Schedule
        Text(
            text = "Today",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(8.dp))

        //EXERCISE 5
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            ScheduleRow(time = "09:00", title = "CS101 Intro", room = "Lab 3")
            ScheduleRow(time = "11:00", title = "MATH210", room = "A-204")
            ScheduleRow(time = "14:00", title = "Soft Skills", room = "Hall 1")
        }

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

// EXERCISE 5
@Composable
fun ProfileHeader(name: String, status: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )
        Column {
            Text(
                text = name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = status,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun ScheduleRow(time: String, title: String, room: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = time)
        Text(text = title)
        Text(text = room)
    }
}

@Preview(showBackground = true)
@Composable
fun CampusCardPreview() {
    CampusCardLabTheme {
        CampusCard()
    }
}