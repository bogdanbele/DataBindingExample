package com.bogdanbele.planday.model

data class GuidesResponse(
    val data: List<Guide>,
    val total: String
)

data class Guide(
    val endDate: String,
    val icon: String,
    val login_required: Int,
    val name: String,
    val objType: String,
    val startDate: String,
    val url: String,
    val venue: Venue
)

class Venue(
)