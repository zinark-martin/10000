package com.example.viewmodeltest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModel(countResume: Int) : ViewModel() {
    var counter = countResume
}

class MainViewModelFactory(private val countResume : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //这里可以创建实例是因为create方法的执行实际和Activity生命周期无关
        return MainViewModel(countResume) as T
    }

}