package com.example.contentprovider

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract

import android.provider.ContactsContract.CommonDataKinds.*
import android.view.ViewGroup


import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var MyAdapter: ArrayAdapter<String>
    private val contactsList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this,"你好, 已Create",Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_main)
        MyAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactsList)
        contactsView.adapter = MyAdapter
        doCall()
        doQuery()
        var params: ViewGroup.MarginLayoutParams = Call.layoutParams as ViewGroup.MarginLayoutParams
        params.height += 600
        params.width += 500
        Call.requestLayout()
        //或者Call.setLayoutParams(params)

    }

    private fun doQuery() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 2)
        } else {
            readContacts()
        }
    }

    private fun doCall() {
        Call.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), 1)
            } else {
                call()
                readContacts()
            }
        }
    }

    override fun onRequestPermissionsResult (requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call()
                } else {
                    Toast.makeText(this, "Fine Bitch", Toast.LENGTH_LONG)
                }
            }
            2 -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    readContacts()
                } else {
                    Toast.makeText(this,"不可以查看联系人了哦", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun call() {
        var intent = Intent(Intent.ACTION_CALL)
        intent.data = Uri.parse("tel:10086")
        startActivity(intent)
    }

    private fun readContacts() {
        contentResolver.query(Phone.CONTENT_URI, null, null, null, null)
            ?.apply {
            while (moveToNext()) {
                val displayName = getString(getColumnIndex(Phone.DISPLAY_NAME))
                val number = getString(getColumnIndex(Phone.NUMBER))
                contactsList.add("$displayName\n$number")
            }
            MyAdapter.notifyDataSetChanged()
            close()
        }
    }

}
