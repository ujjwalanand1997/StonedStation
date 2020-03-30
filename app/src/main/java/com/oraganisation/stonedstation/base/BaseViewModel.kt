package com.oraganisation.stonedstation.base

import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BaseViewModel : ViewModel() {
    //Common livedata to invoke common alerts from across the app, from viewModel/view controllers
    private val appCommonAlertObservable = MutableLiveData<String>()
    private val mIsLoading: MutableLiveData<Boolean?> = MutableLiveData()

    @MainThread
    fun alertObservable(): MutableLiveData<String> {
        return appCommonAlertObservable
    }
    fun setIsLoading(isLoading: Boolean) {
        mIsLoading.value = isLoading
    }

    fun getIsLoading(): MutableLiveData<Boolean?>? {
        return mIsLoading
    }
}