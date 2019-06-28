package com.bogdanbele.planday.api

import android.arch.lifecycle.LiveData
import com.bogdanbele.planday.core.ApiResponse
import com.bogdanbele.planday.model.GuidesResponse
import retrofit2.http.GET

interface GuidesApi {
    companion object {
        const val BASE_URL = "https://private-c60ade-guidebook1.apiary-mock.com/"
    }

    @GET("upcomingGuides")
    fun getUpcomingGuides(): LiveData<ApiResponse<GuidesResponse>>
}

