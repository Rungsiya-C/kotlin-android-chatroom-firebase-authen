package com.example.apinew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.FirebaseDatabase

/**
 * A simple [Fragment] subclass.
 */
class DataRealtime : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_data_realtime, container, false)
        // Inflate the layout for this fragment

        val btn2 = view.findViewById<Button>(R.id.btn2)

        //ประกาศตัวแปร DatabaseReference รับค่า Instance และอ้างถึง path ที่เราต้องการใน database
        val mRootRef = FirebaseDatabase.getInstance().getReference()

        //อ้างอิงไปที่ path ที่เราต้องการจะจัดการข้อมูล ตัวอย่างคือ users และ messages
        val mUsersRef = mRootRef.child("users")
        val mMessagesRef = mRootRef.child("messages")



        btn2.setOnClickListener {
            val addMsgText = view.findViewById<EditText>(R.id.addMsgText)
            val friendlyMessage = FriendlyMessage("ไม่ระบุตัวตน : ", addMsgText.text.toString());
            mUsersRef.push().setValue(friendlyMessage);
        }

        return view

    }

    data class FriendlyMessage(
        var username: String? = "",
        var text: String? = ""
    )

}

