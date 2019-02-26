package com.example.jetpacktemplate.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpacktemplate.util.singleArgViewModelFactory

/**
 * MainViewModel designed to store and manage UI-related data in a lifecycle conscious way. This
 * allows data to survive configuration changes such as screen rotations. In addition, background
 * work such as fetching network results can continue through configuration changes and deliver
 * results after the new Fragment or Activity is available.
 *
 * @param repository the data source this ViewModel will fetch results from.
 */
class MainViewModel : ViewModel() { //private val repository: Repository

    companion object {
        /**
         * Factory for creating [MainViewModel]
         *
         * @param arg the repository to pass to [MainViewModel]
         */
        //val FACTORY = singleArgViewModelFactory(::MainViewModel)
    }

    val title = MutableLiveData<Title>()

    init {
        title.value = Title("Hello")
    }

}