package com.bogdanbele.planday

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.bogdanbele.planday.api.AppApi
import com.bogdanbele.planday.core.ApiResponse
import com.bogdanbele.planday.databinding.ActivityMainBinding
import com.bogdanbele.planday.framework.BaseApplication
import com.bogdanbele.planday.model.Guide
import com.bogdanbele.planday.model.GuidesAdapter
import com.bogdanbele.planday.model.GuidesResponse
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var viewModelProvider: ViewModelProvider? = null

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    lateinit var appApi: AppApi

    private val guideList = MutableLiveData<ApiResponse<GuidesResponse>>()

    val guidesObserver: Observer<List<Guide>> = Observer { reseponse ->
        baseContext.let {
            val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
            binding.executePendingBindings()
            binding.recylcerView.adapter = reseponse?.let { it1 -> GuidesAdapter(it1) }
        }
    }




    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        getBaseApplication().applicationComponent.inject(this)


        mainActivityViewModel.getGuides(appApi)
        


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    fun getBaseApplication(): BaseApplication = application as BaseApplication

}
