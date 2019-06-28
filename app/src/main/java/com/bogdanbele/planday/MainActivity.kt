package com.bogdanbele.planday

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet
import android.view.View
import com.bogdanbele.planday.api.AppApi
import com.bogdanbele.planday.framework.BaseApplication

import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var viewModelProvider: ViewModelProvider? = null

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    @Inject
    lateinit var appApi: AppApi

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
