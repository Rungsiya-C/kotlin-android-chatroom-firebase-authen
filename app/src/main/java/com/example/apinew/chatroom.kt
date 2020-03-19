package com.example.apinew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction

/**
 * A simple [Fragment] subclass.
 */
class chatroom : Fragment() {

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_chatroom, container, false)
//    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.activity_main, container, false)

        val fragment_authen = authen()
        val fm = fragmentManager
        val transaction : FragmentTransaction = fm!!.beginTransaction()
        transaction.replace(R.id.head, fragment_authen,"fragment_authen")
        transaction.addToBackStack("fragment_authen")

        transaction.commit()

        return view;
    }



}
