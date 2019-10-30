package com.coder.tvshows.ui.base

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.actionbar_toolbar.*
import kotlin.reflect.KClass

abstract class BaseFragment : DaggerFragment() {
    abstract val layoutId: Int
    abstract val viewModelClass: Class<out BaseViewModel>
    abstract fun provideViewModelFactory(): ViewModelProvider.Factory
    protected lateinit var parentActivity: Activity

    private val viewModelFactory: ViewModelProvider.Factory by lazy { provideViewModelFactory() }

    protected val baseViewModel: BaseViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpToolbar(toolbar)
        initUI()
        setUpObservers()
    }

    @CallSuper
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        parentActivity = activity as FragmentActivity
    }

    abstract fun initUI()

    abstract fun setUpObservers()

    fun setUpToolbar(toolbar: Toolbar, title: String? = null) {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            if (!title.isNullOrBlank()) setTitle(title)
        }
    }
}