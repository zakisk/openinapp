package com.openinapp.domain.models

import com.google.gson.annotations.SerializedName

data class DashboardData(
    @SerializedName("status") var status: Boolean = false,
    @SerializedName("statusCode") var statusCode: Int? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("support_whatsapp_number") var supportWhatsappNumber: String? = null,
    @SerializedName("extra_income") var extraIncome: Double? = null,
    @SerializedName("total_links") var totalLinks: Int? = null,
    @SerializedName("total_clicks") var totalClicks: Int? = null,
    @SerializedName("today_clicks") var todayClicks: Int? = null,
    @SerializedName("top_source") var topSource: String? = null,
    @SerializedName("top_location") var topLocation: String? = null,
    @SerializedName("startTime") var startTime: String? = null,
    @SerializedName("links_created_today") var linksCreatedToday: Int? = null,
    @SerializedName("applied_campaign") var appliedCampaign: Int? = null,
    @SerializedName("data") var data: Data? = null
)

data class Data(
    @SerializedName("recent_links") var recentLinks: List<Link> = listOf(),
    @SerializedName("top_links") var topLinks: List<Link> = listOf(),
    @SerializedName("favourite_links") var favouriteLinks: List<String> = listOf(),
    @SerializedName("overall_url_chart") var overallUrlChart: Map<String, Int> = emptyMap()
)

data class Link(
    @SerializedName("url_id") var urlId: Int? = null,
    @SerializedName("web_link") var webLink: String? = null,
    @SerializedName("smart_link") var smartLink: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("total_clicks") var totalClicks: Int? = null,
    @SerializedName("original_image") var originalImage: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null,
    @SerializedName("times_ago") var timesAgo: String? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("domain_id") var domainId: String? = null,
    @SerializedName("url_prefix") var urlPrefix: String? = null,
    @SerializedName("url_suffix") var urlSuffix: String? = null,
    @SerializedName("app") var app: String? = null,
    @SerializedName("is_favourite") var isFavourite: Boolean? = null
)