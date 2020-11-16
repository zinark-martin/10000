package com.example.quicknote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.quicknote.DB.NotesDatabase
import com.example.quicknote.Repo.NotesRepo
import com.example.quicknote.AddNotes.Notes.ViewModelProviders.MyViewModelFactory
import com.example.quicknote.AddNotes.Notes.ViewModels.NotesViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: NotesViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //1.repository
        val notesRepo = NotesRepo(NotesDatabase(this))
        val viewModelFactory = MyViewModelFactory(notesRepo)
        //2.viewModel
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(NotesViewModel::class.java)
        //3.NavController
        navController = findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

/**
 * 在使用toolbar时, onBackPressed可以使用系统自带的后退按钮
 * onSupportNavigationUP可以使用toolbar的后退按钮后退
 * */
    override fun onSupportNavigateUp(): Boolean {
    //做一次判空再调用popupBackStack, 避免空栈Error
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }

}