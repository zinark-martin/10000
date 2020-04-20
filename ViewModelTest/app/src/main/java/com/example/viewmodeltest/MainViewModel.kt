package com.example.viewmodeltest

import androidx.lifecycle.*

class MainViewModel(countResume: Int) : ViewModel() {

    private val userIdLiveData = MutableLiveData<String>()
    //userIdLiveData是在switch中作为参数传入的(只能是LiveData
    val user: LiveData<User>
            = Transformations.switchMap(userIdLiveData) { userId ->
        Repository.getUser(userId)//通过方法获取的LiveData对象
    }

    //标准写法 封装值
    val counter
        get() = counterPrivate

    private val counterPrivate = MutableLiveData<Int>()

    init {
        counterPrivate.value = countResume
    }


    //在viewModel中调用其它方法来获得LiveData对象
    fun setUserId(userId: String) {
        userIdLiveData.value = userId
    }

    fun plusOne() {
        val count = counterPrivate.value ?: 0
        counterPrivate.value = count + 1
        //或者
        // counter.value = counter.value?.plus(1)
    }

    fun clear() {
        counterPrivate.value = 0
    }

}

class MainViewModelFactory(private val countResume : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //这里可以创建实例是因为create方法的执行实际和Activity生命周期无关
        return MainViewModel(countResume) as T
    }
}