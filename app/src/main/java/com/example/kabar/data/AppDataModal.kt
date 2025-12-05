package com.example.kabar.data

data class NewsCardModel(
    val mainImage: Int,
    val category: String,
    val title: String,
    val channelImage: Int,
    val channelName: String,
    val timeAgo: String
)