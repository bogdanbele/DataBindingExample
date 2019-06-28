package com.bogdanbele.planday

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bogdanbele.planday.api.AppApi
import com.bogdanbele.planday.api.GuidesApi
import com.bogdanbele.planday.core.ApiResponse
import com.bogdanbele.planday.model.GuidesResponse

class MainActivityViewModel(): ViewModel() {

    private val guideList = MutableLiveData<ApiResponse<GuidesResponse>>()

    fun getGuides(appApi:AppApi){
        appApi.getGuides().observeForever { liveData ->
            guideList.postValue(liveData)
        }

    }





}