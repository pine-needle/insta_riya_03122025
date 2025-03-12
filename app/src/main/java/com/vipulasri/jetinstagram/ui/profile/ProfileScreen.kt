package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun ProfileScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
            ProfileHeader()
            Spacer(modifier = Modifier.height(8.dp))
            EditProfileButton()
            Spacer(modifier = Modifier.height(16.dp))
            HighlightSection()
            Spacer(modifier = Modifier.height(16.dp))
            Divider()
            PostsGrid()
        }
    }
}

@Composable
fun ProfileHeader() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .clip(CircleShape)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = "https://randomuser.me/api/portraits/men/1.jpg",
                contentDescription = "Profile Picture",
                modifier = Modifier.size(85.dp).clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ProfileStat("14", "Posts")
            ProfileStat("834", "Followers")
            ProfileStat("162", "Following")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Jacob West", fontWeight = FontWeight.Light, fontSize = 16.sp)
        Text(text = "Digital goodies designer @pixsellz", fontSize = 14.sp, textAlign = TextAlign.Center)
        Text(text = "Everything is designed.", fontSize = 14.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Composable
fun ProfileStat(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(text = label, fontSize = 12.sp)
    }
}

@Composable
fun EditProfileButton() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth(0.85f).height(36.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
        ) {
            Text("Edit Profile", fontSize = 14.sp, color = Color.Black)
        }
    }
}

@Composable
fun HighlightSection() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val highlights = listOf("New", "Friends", "Sport", "Design")
        highlights.forEach { label ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        model = "https://source.unsplash.com/random/50x50",
                        contentDescription = "Highlight",
                        modifier = Modifier.size(55.dp).clip(CircleShape)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = label, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun PostsGrid() {
    LazyVerticalGrid(columns = GridCells.Fixed(3), modifier = Modifier.fillMaxSize()) {
        items(14) {
            Box(
                modifier = Modifier
                    .padding(1.dp)
                    .background(Color.Gray)
                    .size(120.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = "https://source.unsplash.com/random/100x100",
                    contentDescription = "Post Image",
                    modifier = Modifier.size(118.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
