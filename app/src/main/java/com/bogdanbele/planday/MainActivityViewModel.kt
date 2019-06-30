package com.bogdanbele.planday

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.bogdanbele.planday.api.AppApi
import com.bogdanbele.planday.framework.ApiResponse
import com.bogdanbele.planday.model.GuidesResponse

class MainActivityViewModel : ViewModel() {

    var guideList = MutableLiveData<ApiResponse<GuidesResponse>>()

    fun getGuides(appApi: AppApi) {
        appApi.getGuides().observeForever { liveData ->
            if (liveData != null) {
                guideList.postValue(liveData)
            }
        }
    }
}