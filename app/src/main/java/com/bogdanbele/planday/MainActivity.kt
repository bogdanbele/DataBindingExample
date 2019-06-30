package com.bogdanbele.planday

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.bogdanbele.planday.api.AppApi
import com.bogdanbele.planday.core.ApiResponse
import com.bogdanbele.planday.core.ApiSuccessResponse
import com.bogdanbele.planday.databinding.ActivityMainBinding
import com.bogdanbele.planday.framework.BaseApplication
import com.bogdanbele.planday.model.Guide
import com.bogdanbele.planday.model.GuidesAdapter
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
        setSupportActionBar(toolbar)

        getBaseApplication().applicationComponent.inject(this)

        mainActivityViewModel.getGuides(appApi)
        binding.recylcerView.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        mainActivityViewModel.guideList.observeForever {
            val data = it
            if(data is ApiSuccessResponse<GuidesResponse>){
                val items = data.body.data
                binding.recylcerView.adapter = GuidesAdapter(items)
            }
        }
        binding.executePendingBindings()


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    fun getBaseApplication(): BaseApplication = application as BaseApplication

}
