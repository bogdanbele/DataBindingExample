package com.bogdanbele.planday.api

import android.arch.lifecycle.LiveData
import com.bogdanbele.planday.core.ApiResponse
import com.bogdanbele.planday.core.LiveDataCallAdapterFactory
import com.bogdanbele.planday.model.GuidesResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppApi {
    var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(GuidesApi.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(LiveDataCallAdapterFactory())
        .build()

    var api = retrofit.create(GuidesApi::class.java)

    fun getGuides(): LiveData<ApiResponse<GuidesResponse>> {
        return api.getUpcomingGuides()
    }

}