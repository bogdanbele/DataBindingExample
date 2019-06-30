package com.bogdanbele.planday

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.bogdanbele.planday.api.AppApi
import com.bogdanbele.planday.databinding.ActivityMainBinding
import com.bogdanbele.planday.framework.ApiSuccessResponse
import com.bogdanbele.planday.framework.BaseApplication
import com.bogdanbele.planday.model.GuidesResponse
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    lateinit var appApi: AppApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.recylcerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        setSupportActionBar(toolbar)

        getBaseApplication().applicationComponent.inject(this)
        mainActivityViewModel.getGuides(appApi)

        mainActivityViewModel.guideList.observeForever { apiResponse ->
            if (apiResponse is ApiSuccessResponse<GuidesResponse>) {
                val items = apiResponse.body.data
                binding.recylcerView.adapter = GuidesAdapter(items)
            }
        }
    }

    private fun getBaseApplication(): BaseApplication = application as BaseApplication
}
