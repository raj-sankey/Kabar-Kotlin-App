package com.example.kabar.presentation.screens.HomeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.kabar.R
import com.example.kabar.data.NewsCardModel
import com.example.kabar.presentation.state.AppViewModel
import com.example.kabar.presentation.ui.components.news_card.NewsCardItem
import com.example.kabar.presentation.ui.components.scrollable_tab_bar.ScrollableTabBar
import com.example.kabar.presentation.ui.components.topbar.Topbar
import com.example.kabar.presentation.ui.components.trending_news.TrendingNewsItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    appViewModel: AppViewModel,
    modifier: Modifier = Modifier
) {
    // Global state
    val state by appViewModel.uiState.collectAsStateWithLifecycle()
    var selectedTab by rememberSaveable { mutableStateOf(0) }

    val categories = listOf("Top News", "Sports", "Tech", "Health", "Finance", "Entertainment")

    val mockNewsList = listOf(
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Europe",
            title = "Russian warship: Moskva sinks in Black Sea",
            channelImage = R.drawable.news,
            channelName = "BBC",
            timeAgo = "4h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Tech",
            title = "Apple releases new iPhone with AI features",
            channelImage = R.drawable.news,
            channelName = "TechCrunch",
            timeAgo = "2h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Sports",
            title = "Real Madrid wins the Champions League final",
            channelImage = R.drawable.news,
            channelName = "ESPN",
            timeAgo = "1h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "World",
            title = "UN holds emergency meeting over global climate crisis",
            channelImage = R.drawable.news,
            channelName = "Al Jazeera",
            timeAgo = "6h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Business",
            title = "Tesla stock surges after record-breaking quarterly sales",
            channelImage = R.drawable.news,
            channelName = "Reuters",
            timeAgo = "3h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Health",
            title = "New study reveals benefits of a high-protein diet",
            channelImage = R.drawable.news,
            channelName = "Medical Times",
            timeAgo = "8h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Politics",
            title = "Senate passes new bill aimed at improving cybersecurity",
            channelImage = R.drawable.news,
            channelName = "CNN",
            timeAgo = "5h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Entertainment",
            title = "Upcoming Marvel movie breaks pre-sale records",
            channelImage = R.drawable.news,
            channelName = "Variety",
            timeAgo = "7h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Science",
            title = "NASA discovers Earth-like planet in nearby star system",
            channelImage = R.drawable.news,
            channelName = "Space.com",
            timeAgo = "9h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Finance",
            title = "Global markets rise as inflation shows signs of cooling",
            channelImage = R.drawable.news,
            channelName = "Bloomberg",
            timeAgo = "10h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Technology",
            title = "Google announces major updates to its AI ecosystem",
            channelImage = R.drawable.news,
            channelName = "The Verge",
            timeAgo = "12h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Travel",
            title = "Top 10 safest countries to visit in 2024 revealed",
            channelImage = R.drawable.news,
            channelName = "National Geographic",
            timeAgo = "11h ago"
        ),
        NewsCardModel(
            mainImage = R.drawable.news,
            category = "Local",
            title = "City prepares new eco-friendly transport initiative",
            channelImage = R.drawable.news,
            channelName = "Daily Post",
            timeAgo = "13h ago"
        )
    )

    Scaffold(
        contentWindowInsets = WindowInsets(0), // 👈 disables automatic safe padding

        topBar = {
            Topbar(
                modifier = Modifier
                    .padding(top = 50.dp)   // your manual spacing
                    .padding(horizontal = 16.dp)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // 🔹 Trending Section (scrolls away)
            item {
                Spacer(Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Trending",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp
                    )
                    Text("See all")
                }
            }

            item {
                TrendingNewsItem(
                    mainImage = R.drawable.news,
                    category = "Europe",
                    title = "Russian warship: Moskva sinks in Black Sea",
                    channelImage = R.drawable.news,
                    channelName = "BBC News",
                    timeAgo = "4h ago"
                )
            }

            // 🔹 Latest + Tabs: STICKY HEADER
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(top = 8.dp, bottom = 4.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Latest",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 18.sp
                        )
                        Text("See all")
                    }

                    Spacer(Modifier.height(8.dp))

                    ScrollableTabBar(
                        tabs = categories,
                        selectedIndex = selectedTab,
                        onTabSelected = { selectedTab = it }
                    )
                }
            }

            // 🔹 News List
            items(
                items = mockNewsList,
                key = { it.title }
            ) { news ->
                NewsCardItem(
                    mainImage = news.mainImage,
                    category = news.category,
                    title = news.title,
                    channelImage = news.channelImage,
                    channelName = news.channelName,
                    timeAgo = news.timeAgo
                )
            }
        }
    }
}
