package com.example.jetpacktemplate.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlin.LazyThreadSafetyMode.NONE

/**
 * Repository provides an interface to fetch a title or request a new one be generated.
 *
 * Repository modules handle data operations. They provide a clean API so that the rest of the app
 * can retrieve this data easily. They know where to get the data from and what API calls to make
 * when data is updated. You can consider repositories to be mediators between different data
 * sources, in our case it mediates between a network API and an offline database cache.
 */
class Repository(private val titleDao: TitleDao) {


    /**
     * [LiveData] to load title.
     *
     * This is the main interface for loading a title. The title will be loaded from the offline
     * cache.
     *
     * Observing this will not cause the title to be refreshed, use [Repository.refreshTitle]
     * to refresh the title.
     *
     * Because this is defined as `by lazy` it won't be instantiated until the property is
     * used for the first time.
     */
    val title: LiveData<String> by lazy<LiveData<String>>(NONE) {
        Transformations.map(titleDao.loadTitle()) { it?.title }
    }
}