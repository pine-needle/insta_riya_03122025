package com.vipulasri.jetinstagram.ui.favorites

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun FavoritesScreen() {
    var selectedTab by remember { mutableStateOf("You") }

    Surface(color = MaterialTheme.colors.background) {
        Column(modifier = Modifier.fillMaxSize()) {
            TopBar()
            TabSection(selectedTab) { selectedTab = it }
            if (selectedTab == "You") {
                NotificationList()
            } else {
                FollowingNotificationList()
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Activity",
            style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun TabSection(selectedTab: String, onTabSelected: (String) -> Unit) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Following",
                fontSize = 16.sp,
                color = if (selectedTab == "Following") Color.Black else Color.Gray,
                fontWeight = if (selectedTab == "Following") FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.clickable { onTabSelected("Following") }
            )
            Text(
                text = "You",
                fontSize = 16.sp,
                color = if (selectedTab == "You") Color.Black else Color.Gray,
                fontWeight = if (selectedTab == "You") FontWeight.Bold else FontWeight.Normal,
                modifier = Modifier.clickable { onTabSelected("You") }
            )
        }
        Divider(
            modifier = Modifier.fillMaxWidth().height(2.dp),
            color = Color.Black
        )
    }
}

@Composable
fun NotificationList() {
    val notifications = listOf(
        NotificationData("Follow Requests", "User wants to follow you.", true),
        NotificationData("New", "karennne liked your photo.", false),
        NotificationData("Today", "kiero_d, zackjohn and 26 others liked your photo.", false),
        NotificationData("This Week", "craig_love mentioned you in a comment.", false),
        NotificationData("This Week", "martini_rond started following you.", false, isMessage = true),
        NotificationData("This Week", "maxjacobson started following you.", false, isMessage = true),
        NotificationData("This Week", "mis_potter started following you.", true),
        NotificationData("This Month", "rs_humphrey started following you.", false, isMessage = true)
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(notifications) { notification ->
            SectionHeader(notification.section)
            NotificationItem(notification)
        }
    }
}

data class NotificationData(
    val section: String,
    val message: String,
    val showFollowButton: Boolean,
    val isMessage: Boolean = false
)

@Composable
fun SectionHeader(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun NotificationItem(notification: NotificationData) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://randomuser.me/api/portraits/women/1.jpg",
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, Color.Gray, CircleShape)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(notification.message, fontSize = 14.sp)
            Text("3d", fontSize = 12.sp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.weight(1f))

        val InstagramBlue = Color(0xFF1DA1F2)

        if (notification.showFollowButton) {
            Button(
                onClick = {},
                modifier = Modifier.height(32.dp).padding(horizontal = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = InstagramBlue)
            ) {
                Text("Follow", color = Color.White)
            }
        } else if (notification.isMessage) {
            Button(
                onClick = {},
                modifier = Modifier.height(32.dp).padding(horizontal = 8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray)
            ) {
                Text("Message", color = Color.Black)
            }
        } else {
            AsyncImage(
                model = "https://source.unsplash.com/random/50x50",
                contentDescription = "",
                modifier = Modifier.size(40.dp)
            )
        }
    }
    Divider()
}


//  "Following" SECTION IMPLEMENTATION


data class FollowingNotificationData(
    val username: String,
    val action: String,
    val time: String,
    val images: List<String> = emptyList()
)

@Composable
fun FollowingNotificationList() {
    val followingNotifications = listOf(
        FollowingNotificationData("karennne", "liked 3 posts.", "3h",
            listOf("https://source.unsplash.com/random/50x50", "https://source.unsplash.com/random/50x50", "https://source.unsplash.com/random/50x50")
        ),
        FollowingNotificationData("kiero_d, zackjohn and craig_love", "liked joshua_l’s photo.", "3h",
            listOf("https://source.unsplash.com/random/50x50")
        ),
        FollowingNotificationData("craig_love", "liked 8 posts.", "3h",
            listOf("https://source.unsplash.com/random/50x50", "https://source.unsplash.com/random/50x50", "https://source.unsplash.com/random/50x50", "https://source.unsplash.com/random/50x50")
        ),
        FollowingNotificationData("karennne", "liked martini_rond’s comment: @martini_rond Nice!", "3h",
            listOf("https://source.unsplash.com/random/50x50")
        ),
        FollowingNotificationData("maxjacobson", "liked 3 posts.", "3h",
            listOf("https://source.unsplash.com/random/50x50", "https://source.unsplash.com/random/50x50")
        )
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(followingNotifications) { notification ->
            FollowingNotificationItem(notification)
        }
    }
}

@Composable
fun FollowingNotificationItem(notification: FollowingNotificationData) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = "https://randomuser.me/api/portraits/men/1.jpg",
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .border(1.dp, Color.Gray, CircleShape)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text("${notification.username} ${notification.action}", fontSize = 14.sp)
            Text(notification.time, fontSize = 12.sp, color = Color.Gray)

            if (notification.images.isNotEmpty()) {
                Row(modifier = Modifier.padding(top = 4.dp)) {
                    notification.images.forEach { imageUrl ->
                        AsyncImage(
                            model = imageUrl,
                            contentDescription = "Liked Image",
                            modifier = Modifier
                                .size(50.dp)
                                .padding(2.dp)
                                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
                        )
                    }
                }
            }
        }
    }
    Divider()
}

@Preview(showBackground = true)
@Composable
fun FavoritesScreenPreview() {
    FavoritesScreen()
}
