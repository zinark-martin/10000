package com.example.tablayout.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tablayout.R
import kotlinx.android.synthetic.main.fragment_child.*

class ChildFragment:Fragment() {
    companion object{
        fun newInstance(title:String): ChildFragment{
            val args = Bundle()
            args.putString("title",title)
            val fragment = ChildFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_child,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        textView.text = arguments?.getString("title")
    }
}