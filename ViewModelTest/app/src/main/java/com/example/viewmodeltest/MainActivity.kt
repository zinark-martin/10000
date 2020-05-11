package com.example.viewmodeltest

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel:MainViewModel
    private lateinit var sp:SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userDao = AppDatabase.getDatabase(this).userDao()
        val user1 = User("Tom", "Kit", 21)
        val user2 = User("Smith", "Maven", 22)
        addDataBtn.setOnClickListener {
            thread {
                user1.id = userDao.insertUser(user1)
                user2.id = userDao.insertUser(user2)
            }
        }
        updateDataBtn.setOnClickListener {
//            thread (false, true, null,"", -1,{user1.age = 32
//                    userDao.updateUser(user1)})
//            以上是本来的写法, 当我们的参数有默认值, 可以删除括号并把括号内的最后一个元素lambda表达式挪到括号外面时
            thread {
                user1.age = 32
                userDao.updateUser(user1)
            }
        }
        deleteDataBtn.setOnClickListener {
            thread { userDao.deleteUserByLastName("Kit") }
        }
        queryDataBtn.setOnClickListener {
            thread {
                for (user in userDao.loadAllUser()) {
                    Log.d("MainActivity", user.toString())
                }
            }
        }
        doWorkBtn.setOnClickListener {
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java)
                .setInitialDelay(5, TimeUnit.MINUTES).addTag("YO man").build()
            WorkManager.getInstance(this).enqueue(request)
        }


        //一行代码感知生命周期(主动)
        lifecycle.addObserver(MyObserver(lifecycle))

        sp = getPreferences(Context.MODE_PRIVATE)
        val countReserved = sp.getInt("countReserved",0)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(countReserved)).get(MainViewModel::class.java)
        //refreshCounter() 实现观察后这些更改UI的调用函数都不需要了
        plus.setOnClickListener {
            mainViewModel.plusOne()
            //refreshCounter()
        }
        clear.setOnClickListener {
            mainViewModel.clear()
            //refreshCounter()
        }
        getUserBtn.setOnClickListener {
            val userId = (0..100).random().toString()
            mainViewModel.setUserId(userId)
        }
        //LiveData对象可以在调用这个方法来观察数据的变化, 实现实时数据传递
        mainViewModel.counter.observe(this, Observer { count ->
            counting.text = count.toString()
        }) 
        //Observer可以不写, block可以挪到括号外面
        mainViewModel.user.observe(this) { user ->
            val text = user.firstName + ": ${user.lastName}" + " age: ${user.age}"
            counting.text = text
        }
    }

    //重写onPause使在每一次退出前都保存数据进sp
    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("countReserved", mainViewModel.counter.value ?: 0)
        }
    }

    private fun refreshCounter() {
        counting.text = mainViewModel.counter.value.toString()
    }
}
